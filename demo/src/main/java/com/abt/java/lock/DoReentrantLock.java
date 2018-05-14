package com.abt.java.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： @DoReentrantLock
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoReentrantLock {

    public static void main(String[] args) {
        CarBigHouse bigHouse = new CarBigHouse();
        new Thread(new CarSeller(bigHouse)).start();
        new Thread(new Consumer(bigHouse)).start();
    }

    /**
     * 姑且卖车的当做是生产者线程
     */
    public static class CarSeller implements Runnable {

        private CarBigHouse bigHouse;

        public CarSeller(CarBigHouse bigHouse) {
            this.bigHouse = bigHouse;
        }

        public void run() {
            for (int i = 0; i < 10; i++) { // 当做生产者线程，往仓库里边增加汽车，其实是触发增加汽车
                bigHouse.put(); // 模拟生产汽车
                try {
                    Thread.sleep(100); // 模拟汽车生产的间隙
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 姑且买车的人当做是消费者线程
     */
    public static class Consumer implements Runnable {

        private CarBigHouse bigHouse;

        public Consumer(CarBigHouse bigHouse) {
            this.bigHouse = bigHouse;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {// 当做消费者线程，从仓库里边提取汽车，其实是触发，从仓库里边提取一辆汽车出来
                CarBigHouse.Car car = bigHouse.get(); // 模拟消费汽车
                if (null != car) {
                    try {
                        Thread.sleep((long) (Math.random()*1000)); // 模拟消费汽车的间隙
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 这边姑且把CarBigHouse当做是存放车子的仓库房
     */
    public static class CarBigHouse {

        private int carNo = 10000;
        public int carNums = 0; // 这边是仓库房子中车子的数量总数
        public List<Car> carList = new ArrayList<Car>(); // 这边模拟用来放汽车的list
        final ReentrantLock lock = new ReentrantLock();

        public CarBigHouse.Car put() {// 提供给生产者放汽车到仓库的接口
            lock.lock();
            Car car = null;
            try {
                car = CarFactory.makeNewCar();
                car.carName = "car::"+(++carNo);
                carList.add(car);// 加到仓库中去
                carNums++;// 总数增加1
                System.out.println("Product Car --> "+car.carName);
            } finally {
                lock.unlock();
            }
            return car;
        }

        public CarBigHouse.Car get() {// 提供给消费者从这边取汽车接口
            lock.lock();
            CarBigHouse.Car car = null;
            try {
                if (carList.size() != 0) {// size不为空才去取车
                    car = carList.get(carList.size() - 1);// 提取最后一个car
                    carList.remove(car);// 从车库list中移除掉
                    carNums--;// 总数减少1
                    System.out.println("Consume Car --> " + car.carName);
                }
            } finally {
                lock.unlock();
            }
            return car;
        }

        public static class Car {

            public String carName;// 汽车名称
            public double carPrice;// 汽车价格

            public Car() { }

            public Car(String carName, double carPrice) {
                this.carName = carName;
                this.carPrice = carPrice;
            }
        }
    }

    /**
     * 采用静态工厂方式创建car对象，这个只是简单模拟，不做设计模式上的过多考究
     */
    public static class CarFactory {

        private CarFactory() { }

        public static CarBigHouse.Car makeNewCar(String carName, double carPrice) {
            return new CarBigHouse.Car(carName, carPrice);
        }

        public static CarBigHouse.Car makeNewCar() {
            return new CarBigHouse.Car();
        }
    }

}

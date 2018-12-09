package SecondClass;

import javax.security.auth.callback.TextOutputCallback;
import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
/**
 * @Auther: Wobum
 * @Date: 2018/11/13 10:33
 * @Description:
 */
    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType(){
            return this.pet.getType();
        }
    }

    public static class DogCatQueueTest{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueueTest(){
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet, this.count++));
            }else if (pet.getType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet, this.count++));
            }else{
                throw new RuntimeException("err, not dog or cat!");
            }
        }

        public Pet pollAll(){
            if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()){
                //队列是先入先出，先进来的 Pet 类的 count 下，先出。
                if (this.catQ.peek().getCount() < this.dogQ.peek().getCount()){
                    return this.catQ.poll().getPet();
                }else{
                    return this.dogQ.poll().getPet();
                }
            }else if (!this.catQ.isEmpty()){
                return this.catQ.poll().getPet();
            }else if (!this.dogQ.isEmpty()){
                return  this.dogQ.poll().getPet();
            }else{
                throw new RuntimeException("err , queue is empty!");
            }
        }

        public Dog pollDog(){
            if (!this.dogQ.isEmpty()){
                return (Dog) this.dogQ.poll().getPet();
            }else{
                throw new RuntimeException("err, dog queue is empty!");
            }
        }

        public Cat pollCat(){
            if (!this.catQ.isEmpty()){
                return (Cat) this.catQ.poll().getPet();
            }else{
                throw new RuntimeException("err, cat queue is empty!");
            }
        }

        public boolean isEmpty(){
            return this.catQ.isEmpty() && this.dogQ.isEmpty();
        }

        public boolean isDogEmpty(){
            return this.dogQ.isEmpty();
        }

        public boolean isCatEmpty(){
            return this.catQ.isEmpty();
        }

        public static void main(String[] args) {
            DogCatQueueTest test = new DogCatQueueTest();

            Pet dog1 = new Dog();
            Pet cat1 = new Cat();
            Pet dog2 = new Dog();
            Pet cat2 = new Cat();
            Pet dog3 = new Dog();
            Pet cat3 = new Cat();

            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);

            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);

            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);
            /*while (!test.isDogEmpty()) {
                System.out.println(test.pollDog().getType());
            }

            System.out.println("=========================");
            while (!test.isCatEmpty()) {
                System.out.println(test.pollCat().getType());
            }
            System.out.println("=========================");*/
            while (!test.isEmpty()) {
                System.out.println(test.pollAll().getType());
            }
        }
    }
}

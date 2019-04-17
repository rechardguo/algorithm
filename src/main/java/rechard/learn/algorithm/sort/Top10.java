package rechard.learn.algorithm.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

public class Top10 {

    private static final int CAPACITY=10000;
    ExecutorService service=Executors.newFixedThreadPool(100);
    volatile boolean isOneCycleRunDone=false;

    public void getTop10(File file) throws Exception{


        /*FileInputStream fis=new FileInputStream(file);
        FileChannel fc=fis.getChannel();
        fc.write()*/

        BufferedReader reader=new BufferedReader(new FileReader(file));
        String oneLine;
        Worker worker=null;
        List<Future> futurelist=new ArrayList<>();
        List<PersonInfo> list=new ArrayList(CAPACITY);
        int count=0;
        while((oneLine=reader.readLine())!=null){
            String[] info=oneLine.split(",");
            PersonInfo personInfo=new PersonInfo(info[0],Integer.parseInt(info[1])*13+Integer.parseInt(info[2]),1);
            if(count++==CAPACITY){
                PersonInfo[] pis=new PersonInfo[list.size()];
                list.toArray(pis);
                work(pis,service);
                list.clear();
            }
            list.add(personInfo);
        }
        isOneCycleRunDone=true;
        service.shutdown();


    }

    private PersonInfo[] work(PersonInfo[] infos , ExecutorService service) throws ExecutionException, InterruptedException {
        Worker worker=new Worker(infos);
        Future<PersonInfo[]> f=service.submit(worker);
        return f.get();
    }


    private static class PersonInfo{
        String name;
        int salary;
        int totalPerson;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonInfo that = (PersonInfo) o;

            //if (salary != that.salary) return false;
          //  if (totalPerson != that.totalPerson) return false;
            return name != null ? name.substring(0,2).equals(that.name.substring(0,2)) : that.name == null;
        }

        @Override

        public int hashCode() {
            int result = name != null ? name.substring(0,2).hashCode() : 0;
            return result;
        }

        public PersonInfo(String name, int salary, int totalPerson) {
            this.name = name;
            this.salary = salary;
            this.totalPerson = totalPerson;
        }
    }


    private static class Worker implements Callable<PersonInfo[]>{

        TreeMap<PersonInfo,PersonInfo> map=new TreeMap<PersonInfo, PersonInfo>(new Comparator<PersonInfo>() {
            public int compare(PersonInfo o1, PersonInfo o2) {
                return o1.salary>o2.salary?1:0;
            }
        });

        public Worker(PersonInfo[] persons) {
            PersonInfo p=null;
           for(int i=0;i<persons.length;i++){
               if((p=map.get(p))!=null) {
                   p.salary += persons[i].salary;
                   p.totalPerson++;
               }else{
                   p=persons[i];
                   map.put(p,p);
               }
           }
        }

        public PersonInfo[] call() throws Exception {
            PersonInfo[] sortedResult=new PersonInfo[10];
            Iterator<PersonInfo> it=map.descendingKeySet().iterator();
            int index=0;
            while(it.hasNext() && index<10){
                sortedResult[index++]=it.next();
            }
            return sortedResult;
        }
    }
}

import java.util.*;

class Student{
    String name, dept;
    int q1,q2,q3;
    Student(String n,String d,int a,int b,int c){
        name=n; dept=d; q1=a; q2=b; q3=c;
    }
    int total(){ return q1+q2+q3; }
}

public class QuizRanking{
    static List<Student> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();

        while(n-- > 0){
            String[] in = sc.nextLine().split(" ");

            if(in[0].equals("Record")){
                Student s = new Student(in[1], in[2],
                        Integer.parseInt(in[3]),
                        Integer.parseInt(in[4]),
                        Integer.parseInt(in[5]));
                list.add(s);
                System.out.println("Record Added: " + s.name);
            }
            else if(in[0].equals("Top")){
                if(list.isEmpty()){
                    System.out.println("No Records Available");
                    continue;
                }

                if(in[1].startsWith("Q")){
                    int q = Integer.parseInt(in[1].substring(1));
                    int max = Integer.MIN_VALUE;

                    for(Student s:list){
                        int val = (q==1?s.q1:(q==2?s.q2:s.q3));
                        max = Math.max(max,val);
                    }

                    for(Student s:list){
                        int val = (q==1?s.q1:(q==2?s.q2:s.q3));
                        if(val==max)
                            System.out.println(s.name+" "+val);
                    }
                } else {
                    String dept = in[1];
                    boolean found=false;
                    int max=Integer.MIN_VALUE;

                    for(Student s:list){
                        if(s.dept.equals(dept)){
                            found=true;
                            max=Math.max(max,s.total());
                        }
                    }

                    if(!found){
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for(Student s:list){
                        if(s.dept.equals(dept) && s.total()==max)
                            System.out.println(s.name+" "+s.total());
                    }
                }
            }
        }
    }
}
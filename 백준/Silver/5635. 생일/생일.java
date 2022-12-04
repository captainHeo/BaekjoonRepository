import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> ar = new ArrayList<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            ar.add(new Student(name, day, month, year));
        }

        Collections.sort(ar, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.year == o2.year) {

                    if (o1.month == o2.month) {
                        return o1.day - o2.day;
                    }

                    return o1.month - o2.month;
                }

                return o1.year - o2.year;
            }
        });

        System.out.println(ar.get(ar.size()-1).name + "\n" + ar.get(0).name);
    }

    static class Student {

        String name;
        int day;
        int month;
        int year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}

package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSaying {
    private static final String DB_FOLDER = "db/wiseSaying";
    private static final String LAST_ID_FILE = DB_FOLDER + "/lastId.txt";

    public static void main(String[] args) {
        List<String> wisesayings = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        int no = 1;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("명령) ");
            String input = sc.nextLine();
            if (input.equals("종료")) { // "종료"와 비교
                System.out.println("프로그램을 종료합니다.");
                break; // 루프 종료
            }
            else if (input.equals("등록")) {
                System.out.println("명언: ");
                String wisesaying = sc.nextLine();
                System.out.println("작가: ");
                String author = sc.nextLine();

                wisesayings.add(wisesaying);
                authors.add(author);
                System.out.println(no + "번 명언이 등록되었습니다.");
                no += 1;

            }else if (input.equals("목록")) {
                System.out.println("번호/작가/명언\n---------------");
                for (int i = 0; i < wisesayings.size(); i++) {
                    if (wisesayings.get(i) == null) {
                        continue;
                    }
                    System.out.println((i + 1) + " / " + authors.get(i) + " / " + wisesayings.get(i));
                }
            } else if (input.equals("삭제")) {
                System.out.println("삭제할 명언 번호) ");
                int number = Integer.parseInt(sc.nextLine());

                if (number > 0 && number <= wisesayings.size()) {

                    int index = number - 1;

                    if (wisesayings.get(index) == null) {
                        System.out.println(number + "번 명언은 이미 삭제된 항목입니다.");
                    } else {
                        System.out.println(number + "번 명언이 삭제되었습니다.");
                        wisesayings.set(index, null);
                        authors.set(index, null);
                    }

                } else {
                    System.out.println("잘못된 번호입니다.");
                }

            } else if (input.equals("수정")) {

                System.out.println("수정할 명언 번호) ");
                int number = Integer.parseInt(sc.nextLine());

                if (number > 0 && number <= wisesayings.size()) {

                    int index = number - 1;

                    System.out.println("명언(기존):" + wisesayings.get(index));
                    System.out.print("명언: ");
                    String revWisesaying = sc.nextLine();

                    System.out.println("작가(기존):" + authors.get(index));
                    System.out.print("작가: ");
                    String revAuthor = sc.nextLine();

                    wisesayings.set(index, revWisesaying);
                    authors.set(index, revAuthor);
                } else {
                    System.out.println("잘못된 번호입니다.");
                }
            }
        }
        sc.close();
    }
}
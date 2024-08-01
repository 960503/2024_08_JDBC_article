package com.koreaIT.JAM;
import java.util.Scanner;
import java.util.ArrayList;
import com.koreaIT.JAM.dto.Article;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("== 프로그램 시작 ==");

		int lastArticleid = 0;

		ArrayList<Article> articles = new ArrayList<>();

		while (true) {

			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}

			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String body = sc.nextLine();

				lastArticleid++;

				Article article = new Article(lastArticleid, title, body);


				articles.add(article);

				System.out.printf("%d번 글이 생성되었습니다.\n", lastArticleid);

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {

					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.println("번호	|	제목");

				for (int i = articles.size() - 1; i >= 0; i--) {

					Article article = articles.get(i);

					System.out.printf("%d	|	%s\n", article.getId(), article.getTitle());
				}

			} else {

				System.out.println("존재하지 않는 명령어입니다.");

			}

			if (cmd.equals("exit")) {

				break;
			}

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}
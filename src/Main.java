import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados da " + i + "º aula");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char option = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();

            if (option == 'c'){
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                list.add(new Video(url,seconds,title));
            }else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                list.add(new Task(description,questionCount,title));
            }

        }
            int sum = 0;
            System.out.println();
            for (Lesson lesson:list){
            int totalSeconds = lesson.duration();
            sum += totalSeconds;

        }

        System.out.println("Duração total do curso = " + sum + " segundos");

      sc.close();
    }
}
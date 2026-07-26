import java.util.ArrayList;

public class QuestionBank {

    public static ArrayList<Question> getQuestions() {

        ArrayList<Question> list = new ArrayList<>();

        list.add(new Question(
                "Which keyword creates an object in Java?",
                new String[]{
                        "class",
                        "new",
                        "extends",
                        "this"
                },
                1));

        list.add(new Question(
                "JVM stands for",
                new String[]{
                        "Java Variable Machine",
                        "Java Virtual Machine",
                        "Joint Virtual Machine",
                        "Java Vendor Machine"
                },
                1));

        list.add(new Question(
                "Which package contains Scanner?",
                new String[]{
                        "java.io",
                        "java.util",
                        "java.awt",
                        "javax.swing"
                },
                1));

        list.add(new Question(
                "Which loop executes at least once?",
                new String[]{
                        "for",
                        "while",
                        "do-while",
                        "foreach"
                },
                2));

        list.add(new Question(
                "Which company developed Java?",
                new String[]{
                        "Apple",
                        "Microsoft",
                        "Sun Microsystems",
                        "Google"
                },
                2));

        list.add(new Question(
                "Which symbol ends a Java statement?",
                new String[]{
                        ":",
                        ";",
                        ".",
                        ","
                },
                1));

        list.add(new Question(
                "Which collection stores unique values?",
                new String[]{
                        "ArrayList",
                        "HashSet",
                        "Vector",
                        "LinkedList"
                },
                1));

        list.add(new Question(
                "Which keyword is used for inheritance?",
                new String[]{
                        "extends",
                        "implements",
                        "inherit",
                        "super"
                },
                0));

        list.add(new Question(
                "Which method starts a Java program?",
                new String[]{
                        "run()",
                        "start()",
                        "main()",
                        "execute()"
                },
                2));

        list.add(new Question(
                "Java is a",
                new String[]{
                        "Programming Language",
                        "Operating System",
                        "Compiler",
                        "Browser"
                },
                0));

        return list;
    }

}
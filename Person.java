class Person {
    private static int idCounter = 1;

    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
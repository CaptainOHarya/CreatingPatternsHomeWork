package creatingpatterns.builderHomeWork;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String address;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


    public void setAge(int age) {
        this.age = age;
    }

    // Известен ли возраст
    public boolean hasAge() {
        if (age == 0) return false;
        return true;

    }

    // Известен ли город
    public boolean hasAddress() {
        if (address == null) return false;
        return true;

    }

    public int happyBirthday() {
        return age = age + 1;


    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Person {" +
                " name=" + name +
                ", surname=" + surname +
                ", age=" + age +
                ", adress=" + address + '}';
    }

    // Создадим статический метод для создания объекта
    public static PersonBuilder builder() {
        return new Person().new PersonBuilder();
    }

    // Метод для получения полузаполненного билдера для ребёнка в класс Person
    public PersonBuilder newChildBuilder() {
        return builder()
                .buildSurname(Person.this.surname)
                .buildAddress(Person.this.address);
    }

    public class PersonBuilder {
        private PersonBuilder() {
        }


        public PersonBuilder buildName(String name) {
            Person.this.name = name;
            return this;

        }

        public PersonBuilder buildSurname(String surname) {
            Person.this.surname = surname;
            return this;

        }

        public PersonBuilder buildAge(int age) {
            Person.this.age = age;
            return this;

        }

        public PersonBuilder buildAddress(String address) {
            Person.this.address = address;
            return this;

        }

        public Person build() throws IllegalStateException, IllegalArgumentException {

            if (name == null || name.isEmpty()  )
                throw new IllegalStateException("Атрибут name не определён");
            if (surname == null || surname.isEmpty()  )
                throw new IllegalStateException("Атрибут surname не определён");
            if (hasAge() == false)
                throw new IllegalStateException("Атрибут age не определён");
            if (hasAddress() == false)
                throw new IllegalStateException("Атрибут address не определён");
            if (age < 0) {
                throw new IllegalArgumentException("Возраст человека не может быть отрицательным");

            }

            return Person.this;
        }
    }
}

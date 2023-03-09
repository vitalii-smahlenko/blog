Тестове завдання для Junior Java Software Engineer: 
----
Окай, потрібно зробити сервер на наступних технологіях: Java 8, Spring Boot, Spring Data, Apache Maven. <br />
БД in-memory, скажімо H2. <br />
В базі даних зв'язок один до багатьох між User та Article. User має такі поля: id, name, age. Article має такі поля: id, text, color (enum). <br />
На старті аплікації в БД повинно добавлятися 5-10 випадкових Users з Articles. 

**Потрібно зробити наступний АРІ:**

 - Дістати всіх Users, в яких age більше за якесь значення 
 - Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а 
 - Дістати унікальні name з Users, в яких більше ніж 3 Articles 
 - Зберегти User 
 - Зберегти Article 
 - Також потрібно зробити наступний тип security: JWT-based 
 - Також потрібно написати 1-2 JUnit тести на будь який з цих методів АРІ (на контролери, на сервіси, на ДАО-рівень). Тести повинні бути (!) якісні 

Залити цей код на GitHub і написати README як проект запускати Створити колекцію в Postman або написати запити за допомогою curl тулзи, щоб можна було легко потестувати (залити це в README або будь яким іншим відомим способом)

Виконано
- На старті аплікації в БД повинно добавлятися 5-10 випадкових Users з Articles.
- Дістати всіх Users, в яких age більше за якесь значення
  - для цього потрібно кинути запит на http://localhost:8080/users/getAllByAgeAfter?age=33 (33 це вік, його можна міняти)
- Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а 
  - http://localhost:8080/users/getAllByArticleColor?color=BLUE (BLUE це колір, його можна міняти)
- Дістати унікальні name з Users, в яких більше ніж 3 Articles 
  - http://localhost:8080/users/getUsersWithUniqueName
- Зберегти User
- Зберегти Article 
- Написав 1 JUnit
- БД in-memory H2
  - http://localhost:8080/h2-console (пароль sa - його можна змінити в application.properties)
- Дял того щоб додати User через POST-запит, можна використовувати Postman
  приклад JSON для цього<br />
{ "name": "Nina", "age": 33, <br />
    "articles": <br />
    [ { "text": "Article 0", "color": "BLUE" }, <br />
    { "text": "Article 1", "color": "GREEN" }, <br />
    { "text": "Article 2", "color": "PURPLE" }, <br />
    { "text": "Article 3", "color": "PURPLE" }, <br />
    { "text": "Article 4", "color": "BLUE" } ] <br />
}
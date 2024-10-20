# CircleDevs-TestTaskJavaBackend-

В данной репозиторий храниться пример решения тестового задания (создание сервиса для работы со списком задач) от компаний CircleDevs на позицию Java Backend.
(ссылка на задание: https://docs.google.com/document/d/1LGHeBSbZ9h5KKHaSIbKBkuKoPTMS2hqq/edit)

Описание структуры.

StartTaskListApplication.java
  Класс для запуска приложения.

TaskController.java 
  Контроллер для управления задачами. Предоставляет API для создания и получения задач.

 TaskDTO.java
   DTO (Data Transfer Object) для представления задачи.Используется для передачи данных о задаче между различными компонентами приложения.

Task.java
  Сущность "Задача" (Task) для приложения TaskList. Представляет собой объект, содержащий информацию о задаче.

TaskFacade.java
  Фасад для работы с задачами. Предоставляет методы для создания, получения всех, получения по ID, а также для преобразования объектов между DTO и Entity.

TaskMapper.java
  Класс-маппер для преобразования объектов Task и TaskDTO. Этот класс предоставляет методы для преобразования объектов Task в TaskDTO и наоборот.

 interface  TaskRepository
  Этот интерфейс представляет собой репозиторий для работы с сущностями `Task` в базе данных. Он использует интерфейс `JpaRepository` из Spring Data JPA, который предоставляет базовые методы для работы с объектами:

interface TaskService
       Предоставляет методы для создания, получения и поиска задач.

TaskServiceImpl.java
    Сервис для работы с задачами. Предоставляет методы для создания, получения списка, получения задачи по ID.

TaskControllerTestRestAssured.java
      Класс для тестирования приложения с помощью Rest Assured.
      

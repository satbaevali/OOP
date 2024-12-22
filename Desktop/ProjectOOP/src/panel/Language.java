package panel;

public enum Language {
    EN, RU, KZ;

    // Method to get the menu option for the student
    public static String getMenuStudent(int option, Language lang) {
        switch (lang) {
            case EN:
                return switch (option) {
                    case 1 -> "1: News";
                    case 2 -> "2: View Courses";
                    case 3 -> "3: Register for Courses";
                    case 4 -> "4: View info about teacher of a specific course";
                    case 5 -> "5: View Marks";
                    case 6 -> "6: View Transcript";
                    case 7 -> "7: Rate Teachers";
                    case 8 -> "8: Get Transcript";
                    case 9 -> "9: Change password";
                    case 10 -> "10: Exit";
                    default -> "Invalid option. Please try again.";
                };
            case RU:
                return switch (option) {
                    case 1 -> "1: Новости";
                    case 2 -> "2: Просмотр курсов";
                    case 3 -> "3: Зарегистрироваться на курсы";
                    case 4 -> "4: Просмотр информации о преподавателе курса";
                    case 5 -> "5: Просмотр оценок";
                    case 6 -> "6: Просмотр транскрипта";
                    case 7 -> "7: Оценить преподавателей";
                    case 8 -> "8: Получить транскрипт";
                    case 9 -> "9: Студенческие организации";
                    case 10 -> "10: Выход";
                    default -> "Неверный выбор. Пожалуйста, попробуйте снова.";
                };
            case KZ:
                return switch (option) {
                    case 1 -> "1: Жаңалықтар";
                    case 2 -> "2: Курстарды көру";
                    case 3 -> "3: Курстарға тіркелу";
                    case 4 -> "4: Арнайы курстың оқытушысы туралы ақпаратты көру";
                    case 5 -> "5: Бағаларды көру";
                    case 6 -> "6: Транскриптті көру";
                    case 7 -> "7: Оқытушыларды бағалау";
                    case 8 -> "8: Транскрипт алу";
                    case 9 -> "9: Студенттік ұйымдар";
                    case 10 -> "10: Шығу";
                    default -> "Қате таңдау. Қайтадан көріңіз.";
                };
            default:
                return "Invalid option. Please try again.";
        }
    }

    // Method to get the menu options for the teacher
    public static String getMenuTeacher(int option, Language lang) {
        switch (lang) {
            case EN:
                return switch (option) {
                    case 1 -> "1: View Courses";
                    case 2 -> "2: Manage Courses";
                    case 3 -> "3: View Students info";
                    case 4 -> "4: Put Marks";
                    case 5 -> "5: Send Messages to Employees";
                    case 6 -> "6: Send Complaints";
                    case 9 -> "9: Change password";
                    case 10 -> "10: Exit";
                    default -> "Invalid option. Please try again.";
                };
            case RU:
                return switch (option) {
                    case 1 -> "1: Просмотр курсов";
                    case 2 -> "2: Управление курсами";
                    case 3 -> "3: Просмотр информации о студентах";
                    case 4 -> "4: Поставить оценки";
                    case 5 -> "5: Отправить сообщения сотрудникам";
                    case 6 -> "6: Отправить жалобы";
                    case 9 -> "9: Изменить пароль";
                    case 10 -> "10: Выход";
                    default -> "Неверный выбор. Пожалуйста, попробуйте снова.";
                };
            case KZ:
                return switch (option) {
                    case 1 -> "1: Курстарды көру";
                    case 2 -> "2: Курстарды басқару";
                    case 3 -> "3: Студенттер туралы ақпаратты көру";
                    case 4 -> "4: Бағалар қою";
                    case 5 -> "5: Қызметкерлерге хабарламалар жіберу";
                    case 6 -> "6: Шағымдар жіберу";
                    case 9 -> "9: Құпиясөзді өзгерту";
                    case 10 -> "10: Шығу";
                    default -> "Қате таңдау. Қайтадан көріңіз.";
                };
            default:
                return "Invalid option. Please try again.";
        }
    }

    // Method to get the menu options for the admin to manage users
    public static String getMenuAdmin(int option, Language lang) {
        switch (lang) {
            case EN:
                return switch (option) {
                    case 1 -> "1: Add User";
                    case 2 -> "2: Remove User";
                    case 3 -> "3: Update User";
                    case 9 -> "9: Change password";
                    case 10 -> "10: Exit";
                    default -> "Invalid option. Please try again.";
                };
            case RU:
                return switch (option) {
                    case 1 -> "1: Добавить пользователя";
                    case 2 -> "2: Удалить пользователя";
                    case 3 -> "3: Обновить пользователя";
                    case 9 -> "9: Изменить пароль";
                    case 10 -> "10: Выход";
                    default -> "Неверный выбор. Пожалуйста, попробуйте снова.";
                };
            case KZ:
                return switch (option) {
                    case 1 -> "1: Пайдаланушы қосу";
                    case 2 -> "2: Пайдаланушыны жою";
                    case 3 -> "3: Пайдаланушыны жаңарту";
                    case 9 -> "9: Құпиясөзді өзгерту";
                    case 10 -> "10: Шығу";
                    default -> "Қате таңдау. Қайтадан көріңіз.";
                };
            default:
                return "Invalid option. Please try again.";
        }
    }
    public static String getMenuManager(int option, Language lang) {
        switch (lang) {
            case EN:
                return switch (option) {
                    case 1 -> "1: View News";
                    case 2 -> "2: Manage Courses";
                    case 3 -> "3: View Students";
                    case 4 -> "4: Assign Teacher to Course";
                    case 5 -> "5: View Statistics";
                    case 6 -> "6: Change Password";
                    case 7 -> "7: Change Language";
                    case 8 -> "8: Exit";
                    default -> "Invalid option. Please try again.";
                };
            case RU:
                return switch (option) {
                    case 1 -> "1: Просмотреть новости";
                    case 2 -> "2: Управлять курсами";
                    case 3 -> "3: Просмотреть студентов";
                    case 4 -> "4: Назначить учителя на курс";
                    case 5 -> "5: Просмотреть статистику";
                    case 6 -> "6: Изменить пароль";
                    case 7 -> "7: Изменить язык";
                    case 8 -> "8: Выход";
                    default -> "Неверный выбор. Пожалуйста, попробуйте снова.";
                };
            case KZ:
                return switch (option) {
                    case 1 -> "1: Жаңалықтарды қарау";
                    case 2 -> "2: Курстарды басқару";
                    case 3 -> "3: Студенттерді көру";
                    case 4 -> "4: Мұғалімді курсқа тағайындау";
                    case 5 -> "5: Статистиканы қарау";
                    case 6 -> "6: Құпия сөзді өзгерту";
                    case 7 -> "7: Тілді өзгерту";
                    case 8 -> "8: Шығу";
                    default -> "Қате таңдау. Қайтадан көріңіз.";
                };
            default:
                return "Invalid option. Please try again.";
        }
    }
    public static String getMenuResearch(int option, Language lang) {
        switch (lang) {
            case EN:
                return switch (option) {
                    case 1 -> "1: Get H-Index";
                    case 2 -> "2: Add New Paper";
                    case 3 -> "3: View Papers";
                    default -> "Invalid option. Please try again.";
                };
            case RU:
                return switch (option) {
                    case 1 -> "1: Получить H-индекс";
                    case 2 -> "2: Добавить новую статью";
                    case 3 -> "3: Просмотреть статьи";
                    default -> "Неверный выбор. Пожалуйста, попробуйте снова.";
                };
            case KZ:
                return switch (option) {
                    case 1 -> "1: H-индекс алу";
                    case 2 -> "2: Жаңа мақала қосу";
                    case 3 -> "3: Мақалаларды көру";
                    default -> "Қате таңдау. Қайтадан көріңіз.";
                };
            default:
                return "Invalid option. Please try again.";
        }
    }




}

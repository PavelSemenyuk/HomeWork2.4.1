public class Main {
    public static void main(String[] args) {

        try {
            registration("qwerty12345", "ytrewq54321", "ytrewq54321");
            System.out.println("ВСЕ ОК!!! Данные приняты!");
        } catch (WrongLoginException e) {
            e.Error();
        } catch (WrongPasswordException e) {
            e.Error();
        }
    }

    public static void registration(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        // ЛОГИН
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        for (int i = 0; i < login.length(); i++) {
            char a = login.charAt(i);
            if (!((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9') || (a == '_'))) {
                throw new WrongLoginException();
            }
        }
        //ПАРОЛЬ
        if (password.length() >= 20) {
            throw new WrongPasswordException();
        }
        for (int i = 0; i < password.length(); i++) {
            char a = password.charAt(i);
            if (!((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9') || (a == '_'))) {
                throw new WrongPasswordException();
            }
        }
        //ПРОВЕРКА ПАРОЛЯ
        if (password.length() != confirmPassword.length()) {
            throw new WrongPasswordException();
        }
    }

}
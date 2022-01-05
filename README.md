# Проект автотестов для мобильного приложения [Waytohey](https://play.google.com/store/apps/details?id=com.waytohey.mobile)

![Главная сайта](https://github.com/vkos15/android_waytohey/blob/master/images/mainPage.png)

# Сборка для запуска в Jenkins 

https://jenkins.autotests.cloud/job/08-vkulikova15-android_waytohey/

Предусмотрена возможность запуска тестов в browserstack и на удаленном сервере с помощью selenoid:

![Сборка в Jenkins](https://github.com/vkos15/android_waytohey/blob/master/images/Jenkins.png)

# Пример запуска тестов из терминала: #

```bash
gradle clean  test -Denvironment=${ENVIRONMENT}
```

 В качестве ${ENVIRONMENT} можно указать  *browserstack*,  *selenoid*, а так же предусмотрен запуск локально на эмуляторе: *-Denvironment=emulator* 
 и на реальном устройстве: *-Denvironment=local*
 
По умолчанию тесты будут запускаться в browserstack

Для хранения ключей доступа и параметров устройства используются Property-файлы: 
- browserstack.properties 
- selenoid.properties 
- local.properties
- emulator.properties

Нужные данные выбираются в зависимости от переданного окружения (-Denvironment)

**Для запуска так же необходимы тестовые данные:**  


Для хранения используются Property-файл prod.properties 

```bash
user_active_login=
user_active_pass=
user_wrong_login=
user_wrong_pass=
exist_email=
```

# Реализованы тесты на следующие разделы:

- стартовый экран приложения
- экран входа
- проверка навигации по основному меню приложения

# Отчеты о прохождении автотестов: #
Формируются с помощью библиотеки **Allure**

**Команда для генерации отчета**:

```bash
allure serve build/allure-results
```

![Отчет Allure](https://github.com/vkos15/android_waytohey/blob/master/images/Allure%20Report%20.png)


## Отчет содержит скриншоты, а так же видео-записи прохождения тестов: ##

![Видео прохождения теста](https://github.com/vkos15/android_waytohey/blob/master/images/video.gif)


# Уведомления о прохождении автотестов: # 

Оповещения о статусе сборки со ссылкой на детальный отчет отправляются в **Telegram**

![Уведомление в Telegram](https://github.com/vkos15/android_waytohey/blob/master/images/Telegram.png)

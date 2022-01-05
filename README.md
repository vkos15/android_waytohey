# Проект автотестов для мобильного приложения [waytohey.com](https://play.google.com/store/apps/details?id=com.waytohey.mobile)

![Главная сайта](https://github.com/vkos15/android_waytohey/blob/master/images/mainPage.png)

# Сборка для запуска в Jenkins 

https://jenkins.autotests.cloud/job/08-vkulikova15-android_waytohey/

Предусмотрена возможность запуска тестов через browserstack и на удаленном selenoid:

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

![Отчет Allure](https://github.com/vkos15/waytohey_tests/blob/main/images/Allure%20Report.png)


## Отчет содержит скриншоты, а так же видео-записи прохождения тестов: ##

![Видео прохождения теста](https://github.com/vkos15/waytohey_tests/blob/main/images/test_profile_video.gif)

## Интеграция с Allure TestOps ##

![Allure TestOps](https://github.com/vkos15/waytohey_tests/blob/main/images/Allure%20TestOps.png)

## Интеграция с Jira ##

Доступен список тест-кейсов, а так же приложен результат запуска автотестов 

![Jira](https://github.com/vkos15/waytohey_tests/blob/main/images/WayToHey%20tests%20Jira%20.png)


# Уведомления о прохождении автотестов: # 

Оповещения о статусе сборки со ссылкой на детальный отчет отправляются в **Telegram**

![Отчет Allure](https://github.com/vkos15/waytohey_tests/blob/main/images/Telegram%20notification.png)


<h1>Игра Казино</h1><br>
<h2>Правила игры</h2>
На экране есть 3 цифры, которые постоянно прокручиваются от 0 до 9 циклично. Для победы нужно вовремя остановить их по очереди.<br>
<br>
<h2>Описание программы</h2>
Архитектура - MVC с событийным управлением.<br>
Использован паттерн "Цепочка обязанностей" для проверки победы.<br>
Программа состоит из:<br>
Main - главный класс;<br>
sample.fxml - разметка окна;<br>
MainController - контроллер сцены для обработки событий, созданных пользователем;<br>
MainModel - модель сцены, хранит её состояние;<br>
Handler - абстрактный суперкласс, описывающий обработчики запроса;<br>
LoseHandler, WinHandler - обработчики запроса, наследники Handler;<br>
ActionChain - класс для построения цепочки обязанностей.<br>
<br>
<h2>Диаграмма классов</h2>
<img src="https://i.imgur.com/nHFkAiP.png">

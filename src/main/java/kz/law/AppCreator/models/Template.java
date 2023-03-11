package kz.law.AppCreator.models;

public interface Template {
    String TEMPlATE = "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n" +
            "    <style>\n" +
            "        body {\n" +
            "            font-size: 11pt; font-family: KZ Times New Roman;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "        tr, td {\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "        table.CSSTable {\n" +
            "            width: 100%;\n" +
            "            border-width: 1px;\n" +
            "            border-spacing: 0px;\n" +
            "            border-style: solid;\n" +
            "            border-color: black;\n" +
            "            border-collapse: collapse;\n" +
            "            background-color: white;\n" +
            "            margin-left: auto;\n" +
            "            margin-right: auto;\n" +
            "        }\n" +
            "        table.CSSTable th {\n" +
            "            border-width: 1px;\n" +
            "            padding: 0px;\n" +
            "            border-style: solid;\n" +
            "            border-color: black;\n" +
            "            background-color: white;\n" +
            "        }\n" +
            "        table.CSSTable td {\n" +
            "            border-width: 1px;\n" +
            "            padding: 0px;\n" +
            "            border-style: solid;\n" +
            "            border-color: black;\n" +
            "            background-color: white;\n" +
            "        }\n" +
            "\n" +
            "        .logoImg{\n" +
            "            margin-left: auto;\n" +
            "            margin-right: 100%;\n" +
            "            width: 200px;\n" +
            "            float: left\n" +
            "        }\n" +
            "\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<table style=\"margin-left: 30%; font-weight: bolder\">\n" +
            "    <tr>\n" +
            "        <td>SDCL // Galaxy үшін қызмет көрсету /жұмыс Шартын жасауға өтінім / Заявка</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>заключение Договора на оказание услуг/работ </td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>для SDCL // Galaxy</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>1.Өтінім бастамашысы туралы мәліметтер / Сведения об Инициаторе Заявки:</td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "<div style=\"text-align: left;\">\n" +
            "    <p>Аты/жөні/ ФИО: ${fullName}</p>\n" +
            "    <p>Лауазымы/Должность: ${jobTitle}</p>\n" +
            "    <p>Байланыс деректері / Контактные данные: ${phoneNumber}</p>\n" +
            "</div>\n" +
            "<table class=\"CSSTable\">\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Тауар/қызмет атауы/ Наименование товара/услуги</td>\n" +
            "        <td style=\"text-align: center\">Сатып алу мақсаты мен негізділігі (жұмыс беруші актісіне немесе заң нөміріне сілтеме)/\n" +
            "            Цели и обоснования покупки (ссылка на акт работодателя или норму закона)\n" +
            "        </td>\n" +
            "        <td>Өлшем бірлігі және саны / Единица измерения и количество</td>\n" +
            "        <td>Салық пен міндетті төлемдер ескерілген бағасы / Цена с учетом налогов и обязательных платежей (в тенге)</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">${serviceName}</td>\n" +
            "        <td style=\"text-align: center\">${target}</td>\n" +
            "        <td style=\"text-align: center\">${amount}</td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "<h3 style=\"float: left\">Сауалнама / Анкета</h3>\n" +
            "\n" +
            "<table class=\"CSSTable\">\n" +
            "    <tr>\n" +
            "        <td>1 Тарап (толық атауы) / Сторона 1 (полное наименование)</td>\n" +
            "        <td>${sideOne}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">2 Тарап (толық атауы) / Сторона 2 (полное наименование)</td>\n" +
            "        <td style=\"text-align: center\">${sideTwo}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">2 Тарап (толық атауы) / Сторона 2 (полное наименование)</td>\n" +
            "        <td style=\"text-align: center\">${sideTwo}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Шартқа қол қойылған күн / Дата подписания договора</td>\n" +
            "        <td style=\"text-align: center\">${signedDate}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Шарт түрі және мәні / Вид и предмет договора</td>\n" +
            "        <td style=\"text-align: center\">${agreementType }</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Шарт объектісі/-лері (белгілері және сипаттамасы, мақсаты мен арналымы)/ Объект/ы договора (характеристика и описание, цель и назначение)</td>\n" +
            "        <td style=\"text-align: center\">${conditionalObjects}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Ерекше талаптары / Особые условия</td>\n" +
            "        <td style=\"text-align: center\">${specialRequirements}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Шарт сомасы мен салық ерекшеліктері (ҚҚС және т.б.) / Сумма договора и налоговые особенности (НДС и т. д.)</td>\n" +
            "        <td style=\"text-align: center\">${dealAmount}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">Төлеу механизмі (тәртібі, тәсілі) / Механизм оплаты (порядок, способы)</td>\n" +
            "        <td style=\"text-align: center\">${payment}</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td style=\"text-align: center\">1 Тараптың деректемелері (телефоны, БСН/ЖСН, мекен-жайы, ЖСК, БСК, банк атауы, Кбе және басқа болатын ақпарат) / Реквизиты Стороны 1 (телефон, БИН/ИИН, адрес, ИИК, БИК, наименование банка, Кбе и иная имеющаяся информация)</td>\n" +
            "        <td style=\"text-align: center\">\n" +
            "            1. ${iinBin} <br></br>\n" +
            "            2. ${address} <br></br>\n" +
            "            3. ${jskBank} <br></br>\n" +
            "            4. ${additionalInfo} <br></br>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
}

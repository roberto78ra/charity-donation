<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Donation add page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<header class="header--form-page">
    <jsp:include page="../include/header.jsp"></jsp:include>

       <div class="slogan container container--90">
            <div class="slogan--item">
                <h1>
                    Oddaj rzeczy, których już nie chcesz<br/>
                    <span class="uppercase">potrzebującym</span>
                </h1>
                <div class="slogan--steps">
                    <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                        <ul class="slogan--steps-boxes">
                            <li>
                                <div><em>1</em><span>Wybierz rzeczy</span></div>
                            </li>
                            <li>
                                <div><em>2</em><span>Spakuj je w worki</span></div>
                            </li>
                            <li>
                                <div><em>3</em><span>Wybierz fundację</span></div>
                            </li>
                            <li>
                                <div><em>4</em><span>Zamów kuriera</span></div>
                            </li>
                        </ul>
                </div>
            </div>
       </div>
</header>
<body>
    <section class="form--steps">
        <div class="form--steps-instructions">
            <div class="form--steps-container">
                <h3>Wazne!</h3>
                <p data-step="1" class="active">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="2">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="3">
                    Wybierz jedną, do
                    której trafi Twoja przesyłka.
                </p>
                <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
            </div>
        </div>

        <div class="form--steps-container">
            <div class="form--steps-counter">Krok <span>1</span>/4</div>

            <!-- STEP 1: class .active is switching steps -->
            <form:form method="post" modelAttribute="donation" id="form">
                <div data-step="1" class="active">
                    <h3>Zaznacz co chcesz oddać:</h3>
                    <c:forEach items="${allCategories}" var="category">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="categories" value="${category}"/>
                                <span class="checkbox"></span>
                                <span class="description">${category.name}</span>
                            </label>
                        </div>
                    </c:forEach> <br/>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        <form:input path="quantity" id="quantityForm" name="quantityForm"/>
                    </label>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" id="buttonStepForm2">Dalej</button>
                </div>
            </div>


            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <div class="form-group form-group--checkbox">
                    <c:forEach items="${allInstitutions}" var="institution">
                        <label>
                            <form:radiobutton path="institution" value="${institution}" title="${institution.name}" id="institutionForm"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                               <div class="title">${institution.name}</div>
                               <div class="subtitle">Cel i misja: ${institution.description}</div>
                           </span>
                        </label>
                    </c:forEach>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" class="buttonStepForm">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Ulica <form:input path="street" id="streetForm"/> </label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label> Miasto <form:input path="city" id="cityForm"/> </label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label> Kod pocztowy <form:input path="zipCode" id="zipCodeForm"/> </label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label>Numer telefonu <form:input path="telephone" type="phone" id="telephoneForm"/></label>
                    </div>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Data <form:input type="date" path="pickUpDate" id="dateForm"/> </label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label> Godzina <form:input type="time" path="pickUpTime" id="timeForm"/></label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label> Uwagi dla kuriera
                            <form:textarea path="pickUpComment" rows="5" id="descriptionForm"/>
                        </label>
                    </div>
                    <div class="form-group form-group--inline">
                        <label> Numer telefonu <form:input type="number" path="telephone" id="telephoneForm"/></label>
                    </div>
                </div>
            </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" class="buttonStepForm">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>
                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text"
                                      id="quantityForm"></span
                                >
                            </li>
                            <li>
                            <span class="icon icon-hand"></span>
                            <span class="summary--text" id="institutionForm"></span>
                            </li>
                        </ul>
                    </div>
                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="streetForm"></li>
                                <li id="cityForm"></li>
                                <li id="zipCodeForm"></li>
                                <li id="telephoneForm"></li>
                            </ul>
                        </div>
                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="dateForm"></li>
                                <li id="timeForm"></li>
                                <li id="descriptionForm"></li>
                            </ul>
                        </div>
                    </div>
                </div>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button id="submitForm" type="submit" class="btn">Potwierdzam</button>
                    </div>
                </div>
            </form:form>
        </div>
    </section>
    <jsp:include page="../include/footer.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>
<div class="container">

    <h2>WEB MVC Framework Basic</h2>

    <div class="card">

        <div class="card-header">Book View</div>

        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>번호</td>
                    <td>${book.num}</td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td>${book.price}</td>
                </tr>
                <tr>
                    <td>저자</td>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <td>페이지 수</td>
                    <td>${book.page}</td>
                </tr>
            </table>
            <button class="btn btn-sm btn-primary action">목록</button>
            <button class="btn btn-sm btn-success action">수정</button>
            <button class="btn btn-sm btn-warning action">삭제</button>
        </div>

        <div class="card-footer">인프런_마프 1탄_박매일</div>

    </div>

    <form id="myForm" method="post" action="">
        <input type="hidden" name="num" id="num" value="${book.num}">
    </form>
</div>
<script>
    document.querySelector(".card-body").addEventListener("click", function (e){
        if (e.target.classList.contains("action")){

            let form = document.getElementById("myForm");
            let inputNum = document.getElementById("num")

            switch (e.target.classList[2]) {
                case "btn-primary":
                    form.action="/MF01/list";
                    if(inputNum) {
                        inputNum.remove();
                    }
                    form.method="get";
                    break;
                case "btn-success":
                    form.action="/MF01/updateGet";
                    form.method="post";
                    break;
                case "btn-warning":
                    form.action="/MF01/delete";
                    form.method="post";
                    break;
            }
            form.submit();
        }
    })
</script>
</body>

</html>
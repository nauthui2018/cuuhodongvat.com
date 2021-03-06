<%--
  Created by IntelliJ IDEA.
  User: NguyenVanHuong
  Date: 9/30/20
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <link href="<c:url value="/css/font-face.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/font-awesome-4.7/css/font-awesome.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/font-awesome-5/css/fontawesome-all.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/mdi-font/css/material-design-iconic-font.min.css"/>" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="<c:url value="/vendor/bootstrap-4.1/bootstrap.min.css"/>" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="<c:url value="/vendor/animsition/animsition.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/wow/animate.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/css-hamburgers/hamburgers.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/slick/slick.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/select2/select2.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/perfect-scrollbar/perfect-scrollbar.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/vector-map/jqvmap.min.css"/>" rel="stylesheet" media="all">

    <!-- include summernote css/js -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">

    <!-- Main CSS-->
    <link href="<c:url value="/css/theme.css"/>" rel="stylesheet" media="all">
    <style>
        ::placeholder {
            color: white;
        }
    </style>

</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar2">
        <div class="logo">
            <a href="#">
                <img src="/images/icon/logo-white.png" alt="Cool Admin" />
            </a>
        </div>
        <div class="menu-sidebar2__content js-scrollbar1">
            <nav class="navbar-sidebar2">
                <ul class="list-unstyled navbar__list">
                    <li class="has-sub">
                        <a href="/activities"/><i class="fas fa-table"></i>Activities</a>
                    </li>
                    <li class="has-sub">
                        <a href="/animal"><i class="fas fa-table"></i>Animals</a>
                    </li>
                    <li class="has-sub">
                        <a href="/articles"><i class="fas fa-table"></i>Articles</a>
                    </li>
                    <li class="has-sub">
                        <a href="/donors"/><i class="fas fa-table"></i>Donors</a>
                    </li>
                    <li class="has-sub">
                        <a href="/employees"><i class="fas fa-table"></i>Employees</a>
                    </li>
                    <li class="active has-sub">
                        <a href="/reports"><i class="fas fa-table"></i>Reports</a>
                    </li>
                    <li class="has-sub">
                        <a href="/subcriber"><i class="fas fa-table"></i>Subcribers</a>
                    </li>
                    <li class="has-sub">
                        <a href="/volunteer"><i class="fas fa-table"></i>Volunteers</a>
                    </li>
                    <li class="has-sub">
                        <a href="/users?action=listUsers"><i class="fas fa-table"></i>Users</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container2">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop2">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap2">
                        <div class="logo d-block d-lg-none">
                            <a href="#">
                                <img src="/images/icon/logo-white.png" alt="CoolAdmin" />
                            </a>
                        </div>
                        <div class="header-button2">
                            <div class="header-button-item js-item-menu">
                                <form action="" method="post">
                                    <input style="width: 20vw; border-bottom: white solid 1px; background: none; font-size: medium; " type="text" name="search" placeholder="Search here...">
                                    <i class="button" style="font-size: medium"></i><i class="zmdi zmdi-search ml-2"></i>
                                </form>
                            </div>
                            <div class="header-button-item mr-0 js-sidebar-btn">
                                <i class="zmdi zmdi-menu"></i>
                            </div>
                            <div class="setting-menu js-right-sidebar d-none d-lg-block">
                                <div class="account-dropdown__body">
                                    <div class="account-dropdown__item">
                                        <a href="/users?action=logout"/><i class="fas fa-sign-out-alt mr-3"></i>Logout</a>
                                    </div>
                                    <div class="account-dropdown__item">
                                        <a href="/users?action=update"/><i class="zmdi zmdi-settings mr-3"></i>Change Password</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <aside class="menu-sidebar2 js-right-sidebar d-block d-lg-none">
            <div class="logo">
                <a href="#">
                    <img src="images/icon/logo-white.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar2">
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                        <li class="has-sub">
                            <a href="/activities"/><i class="fas fa-table"></i>Activities</a>
                        </li>
                        <li class="has-sub">
                            <a href="/animal"><i class="fas fa-table"></i>Animals</a>
                        </li>
                        <li class="has-sub">
                            <a href="/articles"><i class="fas fa-table"></i>Articles</a>
                        </li>
                        <li class="has-sub">
                            <a href="/donors"/><i class="fas fa-table"></i>Donors</a>
                        </li>
                        <li class="has-sub">
                            <a href="/employees"><i class="fas fa-table"></i>Employees</a>
                        </li>
                        <li class="active has-sub">
                            <a href="/reports"><i class="fas fa-table"></i>Reports</a>
                        </li>
                        <li class="has-sub">
                            <a href="/subcriber"><i class="fas fa-table"></i>Subcribers</a>
                        </li>
                        <li class="has-sub">
                            <a href="/volunteer"><i class="fas fa-table"></i>Volunteers</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=listUsers"><i class="fas fa-table"></i>Users</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=logout"/><i class="fas fa-sign-out-alt mr-3"></i>Logout</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=update"/><i class="zmdi zmdi-settings mr-3"></i>Change Password</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END HEADER DESKTOP-->

        <!-- BREADCRUMB-->
        <section class="au-breadcrumb m-t-75">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="au-breadcrumb-content">
                                <div class="au-breadcrumb-left">
                                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/reports">
                                        <i class="fas fa-undo mr-1"></i>Back to Dashboard</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- END BREADCRUMB-->

        <section>
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row m-t-30">
                        <div class="col-md-12">
                            <!-- DATA TABLE-->
                            <div class="card">
                                <div class="card-body card-block">
                                    <form action="" method="post" class="form-horizontal">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Name</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" name="reportPersonName" value="${report.reportPersonName}" placeholder="Name report" class="form-control" required>
                                                <c:forEach items="${validate}" var="item">
                                                    <c:if test="${(item.key).equals('Name')}">
                                                        <span class="message" style="color: red; font-size: smaller">${item.value}</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="date-input" class="form-control-label">Address</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="date-input" name="reportAddress" value="${report.reportAddress}" placeholder="Address" class="form-control" required>
                                                <c:forEach items="${validate}" var="item">
                                                    <c:if test="${(item.key).equals('Address')}">
                                                        <span class="message" style="color: red; font-size: smaller">${item.value}</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class="form-control-label">Phone</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="text-input" name="reportPhone" value="${report.reportPhone}" placeholder="Phone" class="form-control" required>
                                                <c:forEach items="${validate}" var="item">
                                                    <c:if test="${(item.key).equals('Phone')}">
                                                        <span class="message" style="color: red; font-size: smaller">${item.value}</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email-input" class=" form-control-label">Email</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="email" id="email-input" name="reportEmail" value="${report.reportEmail}" placeholder="Email" class="form-control" required>
                                                <c:forEach items="${validate}" var="item">
                                                    <c:if test="${(item.key).equals('Email')}">
                                                        <span class="message" style="color: red; font-size: smaller">${item.value}</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="summernote" class=" form-control-label">Description</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea name="reportDescription" id="summernote" required style="border:black 1px solid" >${report.reportDescription}</textarea>
                                                <c:forEach items="${validate}" var="item">
                                                    <c:if test="${(item.key).equals('Description')}">
                                                        <span class="message" style="color: red; font-size: smaller">${item.value}</span>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col-12"  align="right">
                                                <c:if test="${cmt!=null}">
                                                    <p>${cmt}</p>
                                                </c:if>
                                                <a type="reset" class="btn btn-warning btn-sm" href="/reports?action=create" style="width: 90px">
                                                    <i class="fa fa-ban mr-1"></i>Reset</a>
                                                <button type="submit" class="btn btn-primary btn-sm" style="width: 90px; color: black">
                                                    <i class="fas fa-save mr-1"></i>Save</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- END DATA TABLE-->
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- END PAGE CONTAINER-->
    </div>

</div>

<!-- Jquery JS-->
<script src="${pageContext.request.contextPath}/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="${pageContext.request.contextPath}/vendor/slick/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/wow/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/animsition/animsition.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/counter-up/jquery.counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/circle-progress/circle-progress.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/vector-map/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/vendor/vector-map/jquery.vmap.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/vector-map/jquery.vmap.sampledata.js"></script>
<script src="${pageContext.request.contextPath}/vendor/vector-map/jquery.vmap.world.js"></script>

<!-- Main JS-->
<script src="${pageContext.request.contextPath}/js/main.js"></script>

<!-- include summernote css/js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<script>
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: 'Enter content....',
            tabsize: 2,
            height: 200,
            minHeight: 100,
            maxHeight: 500,
            focus: true,
        });
    });
</script>

</body>

</html>
<!-- end document-->


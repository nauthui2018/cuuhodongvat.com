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
    <link href="<c:url value="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="<c:url value="/vendor/animsition/animsition.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/wow/animate.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/css-hamburgers/hamburgers.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/slick/slick.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/select2/select2.min.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/perfect-scrollbar/perfect-scrollbar.css"/>" rel="stylesheet" media="all">
    <link href="<c:url value="/vendor/vector-map/jqvmap.min.css"/>" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="<c:url value="/css/theme.css"/>" rel="stylesheet" media="all">
    <style>
        ::placeholder {
            color: white;
        }
        /* The container <div> - needed to position the dropdown content */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Dropdown Content (Hidden by Default) */
        .dropdown-content {
            margin-left: 40px;
            display: none;
            position: absolute;
            background-color: white;
            min-width: 100px;
            z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
            color: black;
            padding-left: 5px;
            text-decoration: none;
            display: block;
            font-size: smaller;
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {background-color: grey}

        /* Show the dropdown menu on hover */
        .dropdown:hover .dropdown-content {
            display: block;
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
                    <li class="active has-sub">
                        <a href="/employees"/><i class="fas fa-table"></i>Employees</a>
                    </li>
                                        <li class="has-sub">
                                            <a href="/reports"><i class="fas fa-table"></i>Reports</a>
                                        </li>
                                        <li class="has-sub">
                                            <a href="/donors"><i class="fas fa-table"></i>Donors</a>
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
                                <form id="myForm" action="${pageContext.request.contextPath}/employees?action=search" method="post">
                                    <input style="width: 20vw; border-bottom: white solid 1px; background: none; font-size: medium;" type="text" name="searchName" placeholder="Search here..." value="${requestScope["searchName"]}">
                                    <button type="submit" class="btn btn-outline-light" onclick="document.getElementById('myForm').submit();">
                                        <i class="fas fa-search"></i></button>
                                </form>
                            </div>
                            <div class="header-button-item mr-0 js-sidebar-btn">
                                <i class="zmdi zmdi-menu"></i>
                            </div>
                            <div class="setting-menu js-right-sidebar d-none d-lg-block">
                                <div class="account-dropdown__body">
                                    <div class="account-dropdown__item">
                                        <a onclick="window.location.href='/users?action=view'"><i class="zmdi zmdi-account mr-3"></i>Account</a>
                                    </div>
                                    <div class="account-dropdown__item">
                                        <a onclick="window.location.href='/users?action=logout'"><i class="fas fa-sign-out-alt mr-3"></i>Logout</a>
                                    </div>
                                    <div class="account-dropdown__item">
                                        <a onclick="window.location.href='/users?action=updatePassword'"><i class="zmdi zmdi-settings mr-3"></i>Change Password</a>
                                    </div>
                                    <div class="account-dropdown__item">
                                        <a onclick="window.location.href='/users?action=updateInformation'"><i class="zmdi zmdi-settings mr-3"></i>Update Information</a>
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
                        <li class="active has-sub">
                            <a href="/employees"/><i class="fas fa-table"></i>Employees</a>
                        </li>
                        <li class="has-sub">
                            <a href="/reports"/><i class="fas fa-table"></i>Reports</a>
                        </li>
                        <li class="has-sub">
                            <a href="/donors"/><i class="fas fa-table"></i>Donors</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=view"/><i class="zmdi zmdi-account mr-3"></i>Account</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=logout"/><i class="fas fa-sign-out-alt mr-3"></i>Logout</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=updatePassword"/><i class="zmdi zmdi-settings mr-3"></i>Change Password</a>
                        </li>
                        <li class="has-sub">
                            <a href="/users?action=updateInformation"/><i class="zmdi zmdi-settings mr-3 mr-3"></i>Update Information</a>
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
                                <div class="au-breadcrumb-left mt-1">
                                    <a class="btn btn-primary btn-sm" href="/employees?action=create">
                                        <i class="zmdi zmdi-plus mr-1"></i>New Employee</a>
                                </div>
                                <c:if test='${requestScope["message"] != null}'>
                                    <div class="alert alert-dismissible m-b-0" style="color: green">
                                        <a href="#" class="btn close" data-dismiss="alert" aria-label="close" style="color: green">&times;</a>
                                        <strong>Success!</strong> ${requestScope["message"]}
                                    </div>
                                </c:if>
                                <div class="au-breadcrumb-right m-b-10">
                                    <a class="btn btn-primary btn-sm" href="#">Home page</a>
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
                            <div class="table-responsive m-b-40">
                                <table class="table table-borderless table-data3 mydatatable">
                                    <thead>
                                    <tr>
                                        <th>Name
                                            <a href="#sort">
                                                <i class="fa fa-sort" style="color: white"></i></a>
                                        </th>
                                        <th>Gender</th>
                                        <th>Position</th>
                                        <th>Group</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="employee" items="${employeeList}">

                                        <tr>
                                            <td>${employee.employeeName}</td>
                                            <td><c:out value="${employee.employeeGender}"/></td>
                                            <td><c:out value="${employee.employeePosition}"/></td>
                                            <td><c:out value="${employee.employeeGroup}"/></td>
                                            <td><c:out value="${employee.employeeEmail}"/></td>
                                            <td><c:out value="${employee.employeePhone}"/></td>
                                            <td>
                                                <a href="/employees?action=view&id=${employee.employeeID}"><i class="zmdi zmdi-eye" style="color: blue" title="View"></i></a>
                                                <a href="/employees?action=edit&id=${employee.employeeID}"><i class="zmdi zmdi-edit ml-2" style="color: green" title="Edit"></i></a>
                                                <a href="/employees?action=delete&id=${employee.employeeID}"><i class="zmdi zmdi-delete ml-2" style="color: red" title="Delete"></i></a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                    </tbody>
                                </table>
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

<!-- Datatable JS-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>

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
<script>
    $('.mydatatable').DataTable({
        searching: false,
        ordering: false,
        lengthMenu: [[10, 15, 25, 50, -1], [10, 15, 25, 50, "All"]]
    });
</script>
</body>

</html>
<!-- end document-->

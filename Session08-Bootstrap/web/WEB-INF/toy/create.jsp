<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Create Toy</h1>
<hr/>
<div class="row">
    <div class="col-sm-6">
        <form action="<c:url value="/toy/create_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" value="${param.id}" class="form-control" id="id" placeholder="Enter Id" name="id">
            </div>

            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" value="${param.id}" class="form-control" id="name" placeholder="Enter Name" name="name">
            </div>

            <div class="mb-3 mt-3">
                <label for="price" class="form-label">Price:</label>
                <input type="text" value="${param.id}" class="form-control" id="price" placeholder="Enter Price" name="price">
            </div>

            <div class="mb-3 mt-3">
                <label for="expDate" class="form-label">Expired Date:</label>
                <input type="date" value="${param.id}" class="form-control" id="expDate" placeholder="Enter Expired Date" name="expDate">
            </div>

            <div class="mb-3 mt-3">
                <label for="brand" class="form-label">Brand:</label>
                <select class="form-control" name="brand">
                    <c:forEach var="brand" items="${list}" >
                        <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row">
                <div class="col">
                    <button type="submit" name="op" value="create" class="btn btn-outline-primary"><i class="bi bi-check2"></i> Create</button>

                </div>

                <div class="col">
                    <button type="submit" name="op" value="cancel" class="btn btn-outline-danger"><i class="bi bi-x-lg"></i> Cancel</button>
                </div>
            </div>
        </form>
        <i style="color: red">${message}</i>
    </div>

    <div class="col-sm-6">
        <img src="<c:url value="/images/image_background.jpg"/>" width="100%"/>
    </div>
</div>




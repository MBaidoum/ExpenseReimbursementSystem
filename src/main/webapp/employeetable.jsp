<%@ page import="java.util.*"%>
<%@ page import="entities.Ticket"%>

<!Doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Table</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <div class="noise"></div>
    <div class="overlay"></div>
    <div class="table-box">
        <a href="maketicket.html" class="output btn">Make Ticket</a>
        <a href="logout" class="output btn">Logout</a>
        <table class="table table-dark terminal">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">Expense</th>
              <th scope="col">EmployeeId</th>
              <th scope="col">Reason</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            <%
                List<Ticket> tickets = (List<Ticket>) session.getAttribute("tickets");
                for(Ticket t : tickets){
            %>
              <tr>
                <th scope="row" class="output"><%= t.getId()%></th>
                <td class="output"><%= t.getExpense()%></td>
                <td class="output"><%= t.getEmployeeId()%></td>
                <td class="output"><%= t.getReason()%></td>
                <td class="output"><%= t.getStatus()%></td>
              </tr>
            <% } %>
    </div>
  </body>
</html>
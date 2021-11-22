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
    <a href="logout" class="output">Logout</a>
    <table class="table table-dark terminal">
      <thead>
        <tr>
          <th scope="col">id</th>
          <th scope="col">Expense</th>
          <th scope="col">EmployeeId</th>
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
            <td class="output"><%= t.getStatus()%>
            <% if (t.getStatus().equals("pending")) { %>
            <form method="post" action="approve" style="display:inline">
              <input type="hidden" name="ticketId" value=<%= t.getId()%> />
              <input type="submit" class="output btn" value="Approve" />
            </form>
            <form method="post" action="deny" class="output" style="display:inline">
              <input type="hidden" name="ticketId" value=<%= t.getId()%> />
              <input type="submit" class="output btn" value="Deny" />
            </form>
            <% } %>
            </td>
          </tr>
          <% } %>
  </body>
</html>
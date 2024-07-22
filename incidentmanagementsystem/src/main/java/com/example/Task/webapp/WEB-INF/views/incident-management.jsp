<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Incident Management</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/incidents" method="post">
        <input type="text" name="reporterName" placeholder="Reporter Name" required>
        <textarea name="details" placeholder="Incident Details" required></textarea>
        <select name="priority" required>
            <option value="High">High</option>
            <option value="Medium">Medium</option>
            <option value="Low">Low</option>
        </select>
        <select name="status" required>
            <option value="Open">Open</option>
            <option value="In Progress">In Progress</option>
            <option value="Closed">Closed</option>
        </select>
        <button type="submit">Create Incident</button>
    </form>
    <h2>Your Incidents</h2>
    <table>
        <thead>
            <tr>
                <th>Incident ID</th>
                <th>Details</th>
                <th>Priority</th>
                <th>Status</th>
                <th>Reported Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="incident" items="${incidents}">
                <tr>
                    <td>${incident.incidentId}</td>
                    <td>${incident.details}</td>
                    <td>${incident.priority}</td>
                    <td>${incident.status}</td>
                    <td>${incident.reportedDateTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
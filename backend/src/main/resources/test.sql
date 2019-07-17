SELECT convert(date, logins.Date_Time) as Date, users.Name as 'User Name', count(logins.idUser)
FROM USERS as users
       LEFT JOIN Logins_System as logins on logins.idUser = users.idUser
group by users.idUser
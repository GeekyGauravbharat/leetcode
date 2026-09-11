# Write your MySQL query statement below
SELECT p.firstName, P.lastName, a.city, a.state
FROM Person p
LEFT JOIN Address a
    ON p.personID = a.personId;
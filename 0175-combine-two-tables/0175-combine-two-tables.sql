SELECT 
    p.firstName, 
    p.lastName, 
    IFNULL(a.city, NULL) AS city,
    IFNULL(a.state, NULL) AS state
FROM 
    Person p
LEFT JOIN 
    Address a ON p.personId = a.personId;

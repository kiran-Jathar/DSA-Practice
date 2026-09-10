SELECT 
    p.firstName, 
    p.lastName, 
    CASE 
        WHEN a.city IS NULL THEN NULL 
        ELSE a.city 
    END AS city,
    CASE 
        WHEN a.state IS NULL THEN NULL 
        ELSE a.state 
    END AS state
FROM 
    Person p
LEFT JOIN 
    Address a ON p.personId = a.personId;

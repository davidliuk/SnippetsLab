// lc 175
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;

// or
select FirstName, LastName, City, State
from Person left join Address USING(PersonId)

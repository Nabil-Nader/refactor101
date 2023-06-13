### This will be a simple version that related to 

- DRY -> don't repeat yourself principle

## Steps -> compare main branch with this branch to see different
- remove logic from CrudController to be only a controller.
- create an interface for crud, 
  - each time a new class implements it, we can add our logic into crud, cause diffrent crud require a diffrent logic depend on the app, it is better to seprate it and
  - let the service class do all the work 
- create a separate interface to hold crud feature and add this interface to any interface that we might use it later

- replace crudRepository with JpaRepository as this has a lot of feature 

- added a date into Order table so we can sort by date

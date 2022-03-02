
### Problem Statement
## Create a Service to call Third-party API and run a Scheduler based Job

### Features: 

1. Get the Result from API: https://api.jsonbin.io/b/621f9e8a7caf5d67835dbc3b
2. Find a way to convert the Currency to INR
3. Run a Timely Promotion only one at a time
    ### Promotion Set A
      1. There will be a 7% discount on the price if the origin of the products in Africa
      2. There will be a discount of 4% if the product rating is equal to 2 and 8 % if the product rating is below 2
    ### Promotion Set B:
      1. There will be a 12% discount on the prices if the inventory is more than 20
      2. There will be a discount of 7% if the product arrival status is new
### Common Rules:
1. There can only be one discount applied at a time for each Promotion Set
2. You have to apply the discount which provides the highest discount to the customer
3. There will be a default discount of 2% if the price of the item exceeds Rs 1000 and no other discount was applied.

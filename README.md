# Invoicify

### Run
./mvnw spring-boot:run

## Git
#### Create A New Local Branch
```bash
git branch mybranch
git checkout mybranch
```
** Modify Code **
#### Push
```bash
git fetch origin
git rebase origin/master
git push -u origin mybranch
```
#### Open PR
Open a pull request on github.com to merge\
Make sure you select chickok/invoicify not eric283/invoicify\
Wait for code review and approval\
Remind Clayton to remove the merged branch\
The changes will automatically deploy to heroku\
Done!

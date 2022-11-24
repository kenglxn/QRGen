1: set maven version

```
mvn versions:set -DnewVersion=3.0.0 -DgenerateBackupPoms=false
```

2: commit and tag the version

```
git add .
git commit -m "release 3.0.0"
git tag 3.0.0
git push --tags
```

3: set next version

```
mvn versions:set -DnewVersion=3.1.0-SNAPSHOT -DgenerateBackupPoms=false
git add .
git commit -m "set next version"
git push
```

4: update version in readme

5: create the release in github
- git log --pretty=format:"%h %ad%x09%s (%an)" --date=short --merges 2.1.0..2.2.0
- add description for each merged PR with credit to conrtributor

1: set maven version

```
mvn versions:set -DnewVersion=2.1.0 -DgenerateBackupPoms=false
```

2: commit and tag the version

```
git add .
git commit -m "release 2.1.0"
git tag 2.1.0
git push --tags
```

3: set next version

```
mvn versions:set -DnewVersion=2.2.0-SNAPSHOT -DgenerateBackupPoms=false
git add .
git commit -m "set next version"
git push
```

4: update version in readme

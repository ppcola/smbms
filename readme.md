## smbms

[视频](https://www.bilibili.com/video/BV12J411M7Sj?p=30)

[文档](https://www.yuque.com/lajinsinlearn/lpn02c/afp577)


### note

git放弃修改，强制覆盖本地代码

在使用Git的过程中，有些时候我们只想要git服务器中的最新版本的项目，对于本地的项目中修改不做任何理会，就需要用到Git pull的强制覆盖，具体代码如下：

```bash
$ git fetch --all
$ git reset --hard origin/master 
$ git pull
```
git fetch从远程分支拉取代码。

fetch常结合merge一起用，git fetch + git merge == git pull
一般要用git fetch+git merge，因为git pull会将代码直接合并，造成冲突等无法知道，fetch代码下来要git diff orgin/xx来看一下差异然后再合并。



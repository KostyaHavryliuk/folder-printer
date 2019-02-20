Develop an actor model that will traverse the given folder recursively and print its content as a tree to stdout. Main actor should accept one message of type case class PrintTree(path: String).

For example:
```
mainActor ! PrintTree("/tmp")
```
Result:
```
├ com.apple.launchd.AJFpOV1lIQ
│   └ Render
├ com.apple.launchd.bQlljApdmA
│   └ org.macosforge.xquartz:0
├ com.apple.launchd.uCIK1wn3Y8
│   └ Listeners
├ com.apple.launchd.uCIK1wn3Y1
└ powerlog
```

# Reflect

Performance comparation between treeMap-field-reflection and cached-method-invoking

# Requirements

Given a java bean, and return the asc sorted string with key and value

# Hardware

Intel(R) Core(TM) i5-7300HQ CPU @ 2.50GHz @ 2.50GHz

RAM 8G

OS Win10 64bits

#JVM Configuration

-Xms128m

-Xmx750m

-XX:ReservedCodeCacheSize=240m

-XX:+UseConcMarkSweepGC

-XX:SoftRefLRUPolicyMSPerMB=50

-ea

-Dsun.io.useCanonCaches=false

-Djava.net.preferIPv4Stack=true

-XX:+HeapDumpOnOutOfMemoryError

-XX:-OmitStackTraceInFastThrow

# Racers
java bean has 3 fields

1.OriginalReflect (someone's coding)

2.TreeMapFieldReflect

3.CachedMethodReflect

# Result
Cycle for 1 million times as follow:

1.OriginalReflect         3.132 seconds

2.TreeMapFieldReflect     2.480 seconds

3.CachedMethodReflect     2.011 seconds

#
Cycle for 2 million times as follow:

1.OriginalReflect         3.621 seconds

2.TreeMapFieldReflect     3.391 seconds

3.CachedMethodReflect     2.260 seconds

#
Cycle for 5 million times as follow:

1.OriginalReflect         14.247~15.869 seconds

2.TreeMapFieldReflect     12.638~14.097 seconds

3.CachedMethodReflect      8.755~12.286 seconds

#
Cycle for 10 million times as follow:

1.OriginalReflect         21.021~22.762 seconds

2.TreeMapFieldReflect     16.779~17.179 seconds

3.CachedMethodReflect     12.336~12.916 seconds

#
Cycle for 20 million times as follow:

CachedMethodReflect             401.049 seconds

we cannot put so many data in a JVM, the performance is unacceptable
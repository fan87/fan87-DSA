package testing

import ListNode
import NestedInteger
import TreeNode
import java.lang.AssertionError
import java.lang.reflect.InvocationTargetException
import kotlin.reflect.*
import kotlin.reflect.full.createType
import kotlin.reflect.full.instanceParameter

object LeetTest {

    var TEST_INDEX = 0

    var hideSuccess = false

    fun <T> assertReturn(function: KFunction<T>,
                                        expectDeserializer: (T) -> String,
                                        expected: String,
                                        vararg input: String
    ) {
        val name = "[${TEST_INDEX++}]"
        if (function.instanceParameter == null) {
            throw IllegalArgumentException("Invalid function: must be non-static function")
        } else {
            val instance = (function.instanceParameter!!.type.classifier as KClass<*>)
                .constructors
                .firstOrNull { it.parameters.isEmpty() }?.call()
                ?:throw IllegalArgumentException("Could not find primary constructor")
            if (input.size != function.parameters.size - 1) {
                throw IllegalArgumentException("Function's parameters count does not match the input (${function.parameters.size - 1})")
            }
            val argumentType = function.parameters.filter { it.kind != KParameter.Kind.INSTANCE }.map { it.type }
            try {
                val arguments =
                    input.withIndex().map { deserializeArgument(argumentType[it.index], it.value) }.toTypedArray()
                val startNano = System.nanoTime()
                val called = function.call(
                    instance,
                    *arguments
                )
                val timeTaken = System.nanoTime() - startNano
                val output = expectDeserializer(called)
                if (expected != output) {
                    System.err.println("========== TEST REPORT OF $name ==========")
                    for (argument in input) {
                        System.err.println(" - Argument:  $argument")
                    }
                    System.err.println("Assertion Failed for output value!\n" +
                            "  Expected:\n" +
                            "    $expected\n" +
                            "  Actual Output:\n" +
                            "    $output"
                    )
                } else {
                    if (!hideSuccess) {
                        println("========== TEST REPORT OF $name ==========")
                        println("Test has been successfully executed")
                        println("  Output:")
                        println("    $output")
                        println("  Time Taken: $timeTaken (ns)")
                    } else {
                        println("Test $name success")
                    }

                }
            } catch (e: InvocationTargetException) {
                System.err.println("========== TEST REPORT OF $name ==========")
                System.err.println("Test $name has raised an exception")
                e.targetException.printStackTrace()
            }
        }
    }

    private fun deserializeArgument(argumentType: KType, data: String): Any {
        if (argumentType.classifier == Int::class) {
            return __Deserializer__.toInteger(data)
        }
        if (argumentType.classifier == Long::class) {
            return __Deserializer__.toLong(data)
        }
        if (argumentType.classifier == Double::class) {
            return __Deserializer__.toDouble(data)
        }
        if (argumentType.classifier == Char::class) {
            return __Deserializer__.toChar(data)
        }
        if (argumentType.classifier == Boolean::class) {
            return __Deserializer__.toBoolean(data)
        }
        if (argumentType.classifier == String::class) {
            return data
        }
        if (argumentType.classifier == IntArray::class) {
            return __Deserializer__.toIntArray(data)
        }
        if (argumentType.classifier == LongArray::class) {
            return __Deserializer__.toLongArray(data)
        }
        if (argumentType.classifier == BooleanArray::class) {
            return __Deserializer__.toBooleanArray(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == Boolean::class) {
            return __Deserializer__.toBooleanList(data)
        }
        if (argumentType.classifier == DoubleArray::class) {
            return __Deserializer__.toDoubleArray(data)
        }

        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == Int::class) {
            return __Deserializer__.toIntList(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == Long::class) {
            return __Deserializer__.toLongList(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == IntArray::class) {
            return __Deserializer__.toInt2dList(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == LongArray::class) {
            return __Deserializer__.toLong2dList(data)
        }
        if (argumentType.classifier == CharArray::class) {
            return __Deserializer__.toCharArray(data)
        }
        if (argumentType.classifier.toString() == Array::class.toString()) {
            if (argumentType.arguments[0].type!!.classifier == IntArray::class) {
                return __Deserializer__.toInt2dArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == LongArray::class) {
                return __Deserializer__.toLong2dArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == DoubleArray::class) {
                return __Deserializer__.toDouble2dArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == CharArray::class) {
                return __Deserializer__.toChar2dArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == String::class) {
                return __Deserializer__.toStringArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == Array::class &&
                argumentType.arguments[0].type!!.arguments[0].type!!.classifier == String::class
            ) {
                return __Deserializer__.toString2dArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == ListNode::class) {
                return __Deserializer__.toListNodeArray(data)
            }
            if (argumentType.arguments[0].type!!.classifier == TreeNode::class) {
                return __Deserializer__.toTreeNodeArray(data)
            }
        }

        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == String::class) {
            return __Deserializer__.toStringList(data)
        }
        if (argumentType.classifier == Set::class && argumentType.arguments[0].type!!.classifier == String::class) {
            return __Deserializer__.toStringSet(data)
        }
        if (argumentType.classifier == List::class &&
            argumentType.arguments[0].type!!.classifier == List::class &&
            argumentType.arguments[0].type!!.arguments[0].type!!.classifier == String::class
            ) {
            return __Deserializer__.toString2dList(data)
        }
        if (argumentType.classifier == ListNode::class) {
            return __Deserializer__.toListNode(data)
        }
        if (argumentType.classifier == TreeNode::class) {
            return __Deserializer__.toTreeNode(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == TreeNode::class) {
            return __Deserializer__.toTreeNodeList(data)
        }
        if (argumentType.classifier == NestedInteger::class) {
            return __Deserializer__.toNestedInteger(data)
        }
        if (argumentType.classifier == List::class && argumentType.arguments[0].type!!.classifier == NestedInteger::class) {
            return __Deserializer__.toNestedIntegerList(data)
        }
        throw IllegalArgumentException("Un-supported argument type: $argumentType")
    }

}
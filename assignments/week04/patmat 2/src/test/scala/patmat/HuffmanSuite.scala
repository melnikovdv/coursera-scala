package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

import scala.collection.immutable

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times test") {
    val test = "fsaasdbcbcbcc".toList
    val freqs: List[(Char, Int)] = times(test)
    assert(freqs.length === 6)
    assert(freqs(0) === ('a', 2))
    assert(freqs(1) === ('b', 3))
    assert(freqs(2) === ('c', 4))
    assert(freqs(3) === ('d', 1))
    assert(freqs(4) === ('f', 1))
    assert(freqs(5) === ('s', 2))
    println(freqs)

    assert(times("aaa".toList)(0) === ('a', 3))
    assert(times("aaa".toList).length === 1)
    assert(times(Nil) === Nil)
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("french tree decoding") {
    assert(decodedSecret.mkString === "huffmanestcool")
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
      assert(decode(t2, encode(t2)("abd".toList)) === "abd".toList)
    }
  }

  test("convert") {
    new TestTrees {
      val convT1: CodeTable = convert(t1)
      val convT2: CodeTable = convert(t2)

      println ("convert t1: " + convT1)
      assert(convT1.length === 2)
      assert(convT1(0) == ('a', List(0)))
      assert(convT1(1) == ('b', List(1)))

      println ("convert t2: " + convT2)
      assert(convT2.length === 3)
      assert(convT2(0) == ('a', List(0, 0)))
      assert(convT2(1) == ('b', List(0, 1)))
      assert(convT2(2) == ('d', List(1)))
    }
  }

  test("decode and quickEncode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
      assert(decode(t2, quickEncode(t2)("abd".toList)) === "abd".toList)
    }
  }
}

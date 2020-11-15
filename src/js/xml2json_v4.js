/**
 * 基本思路是深度优先加递归  也可以使用栈的完成，因为递归本身就是stack
 * xml可以看出是个n叉的树
 *
 * 例如
 * <users><user><name>tom</name></user><user><name>jame</name></user></users>
 *
 * 转树结构就是
 *
 *       users
 *       /   \
 *     user   user
 *     /       \
 *    name     name
 *
 * 定义了一个parse的方法
 * function parse(str, parent, index)
 * 最开始的parent定义成root={}
 * 当遇到users,判断下个字符是否是<，这里的例子是即<users...,则root={users:{}} ,将root[users]作为<user...的parent传入递归调用
 * 当遇到user,判断下个字符是否是<，这里的例子是即<user... root={users:{user:{}}},将root[users][user]作为<name...的parent传入递归调用
 * 直到遇到name,判断下个字符是否是<,里的例子是tom</name...也就是叶子节点，那就好处理了.parent是root[users][user]={},
 * 则直接root[users][user]={name:tom}  处理后 root={users:{user:{name:tom}}}
 * 处理完叶子节点后就return，这样就返回到user这级，user由于只有1个name结点，处理完return
 * 就返回到users这级,而users继续处理(注意parse方法里do..while的逻辑)到了右边的user节点。
 * 这时候要注意parent[users]是root[users]
 * root={users:{user:{name:tom}}}，parent[users]现在是{user:{name:tom}},而又要加入一个user,
 * 需要将parent[users]改成[],加入已有的user({user:{name:tom}})后再加入一个{}，处理后
 * root={users:[{user:{name:tom}},{}]}, 将root[users][root[users].length-1]作为
 * parent递归传入
 *
 * 整个处理的过程，每个字符只会处理一次，所以时间复杂度是o(n),
 * 由于至少需要一次遍历过程，所以这里的解法应该就是最优了
 *
 * 不足：
 * 1.整个程序错误抛出提示有待改进
 * 2.不够健全，还有各种的case需要处理 例如  <a>3<a
 *
 */
function xml2json(str) {
  if (!str) return null;

  str = str.replace(/\r\n/g, '');
  str = str.replace(/\n/g, '');

  let root = {};
  parse(str, root, 0);
  return root;
}

//index 就是key的第一个字符的位置
function getKey(str, index) {
  let k = '';
  while (str[index] != '>') {
    k += str[index];
    index++;
  }
  return k;
}
//index 就是value的第一个字符的位置
function getValue(str, index) {
  let v = '';
  while (str[index] != '<') {
    v += str[index];
    index++;
  }
  return v;
}

function handleEndNode(str, index, key) {
  //处理</...>
  if (str[index] != '<') throw new Error('格式出错');
  index++; //跳过<
  if (str[index] != '/') throw new Error('格式出错');
  index++;
  //验证结束结点
  let endKey = getKey(str, index);
  index += endKey.length + 1;
  if (key != endKey) throw new Error('格式出错');
  return index;
}

/**
 * 这个方法还是比较复杂的，最麻烦的就是处理{}要转[]的逻辑
 * @param str
 * @param parent 父节点
 * @param index 处理str开始的index
 * @returns {null|number}
 */
function parse(str, parent, index) {
  if (index >= str.length - 1) return null;

  //第一个字符一定要是<开头，不是的就跑错
  if (str[index] != '<') throw new Error('格式错误');

  index++; //跳过<
  let key = getKey(str, index);
  index += key.length + 1;
  //分情况
  let nextChar = str[index];
  if (!nextChar) throw new Error('格式错误');
  if (nextChar != '<') {
    let val = getValue(str, index);
    index += val.length; //跳过value的部分到</a>，index指向<
    if (!parent[key]) {
      parent[key] = val;
    } else if (parent[key] instanceof Array) {
      parent[key].push(val);
    } else {
      let tmp = parent[key];
      parent[key] = [tmp, val];
    }
    return handleEndNode(str, index, key); //叶子节点 return
  } else {
    //遇到<a></a>要跑错
    if (str[index + 1] == '/') throw new Error('格式错误');
    let body;
    if (!parent[key]) {
      parent[key] = {};
      body = parent[key];
    } else if (parent[key] && !(parent[key] instanceof Array)) {
      let tmp = parent[key];
      parent[key] = [tmp, {}];
      body = parent[key][parent[key].length - 1];
    } else {
      parent[key].push({});
      body = parent[key][parent[key].length - 1];
    }
    do {
      index = parse(str, body, index);
    } while (str[index] == '<' && str[index + 1] != '/');
    return handleEndNode(str, index, key); //处理非叶子节点，但是自己包裹的那块完毕后return
  }
}
let xml = '<a><a>1</a></a>';
let json = xml2json(xml);
console.info(JSON.stringify(json));

let xml1 = '<a><c><c1>1</c1></c><c><c1>2</c1></c><c><c1>3</c1></c></a>';
//console.info(xml1);
let json1 = xml2json(xml1);
console.info(JSON.stringify(json1));

let xml2 =
  '<a><c><c1>1</c1></c><c><c1>2</c1></c><c><c1>3</c1></c>' +
  '<c><c1>1</c1></c><c><c1>2</c1></c><c><c1>3</c1></c><b>5</b></a>';
//console.info(xml1);
let json2 = xml2json(xml2);
console.info(JSON.stringify(json2));

let userxml =
  '<list><item>content1</item><item>content2</item><item>content3</item><item><name>hema</name><value>frontend</value></item></list>';
console.info(JSON.stringify(xml2json(userxml)));

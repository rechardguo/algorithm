// 原始 xml
const xml = `
<list>
  <item>content1</item>
  <item>content2</item>
  <item>content3</item>
  <item>
    <name>hema</name>
    <value>frontend</value>
  </item>
</list>
`

// 目标 json
const json = {
    tag: 'list',
    children: [
        {
            tag: 'item',
            children: 'content1'
        },
        {
            tag: 'item',
            children: 'content2'
        },
        {
            tag: 'item',
            children: 'content3'
        },
        {
            tag: 'item',
            children: [
                {
                    tag: 'name',
                    children: 'hema'
                },
                {
                    tag: 'value',
                    children: 'frontend'
                }
            ]
        }
    ]
}

function  Node(tagName){
    this.tag=tagName;
    this.children=null;
    this.getTag=function () {
        return this.tag;
    }
    this.setTag=function (tag) {
        this.tag=tag;
    }
    this.setChildren=function (children) {
        this.children=children;
    }
    this.getChildren=function () {
        return this.children;
    }
}

function xml2json (xml) {
    if(!xml) return null;
    xml = xml.replace(/\r\n/g, '');
    xml = xml.replace(/\n/g, '');
    xml = xml.replace(/>\s+<?/g, '><');
    //console.info(xml)
    let result = new Node();
    parse(xml, result, 0);
    return result;
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
 * @param parent 父节点 有可能是[] 和Node
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
        if (parent instanceof Array) {
            parent.getChildren().push(new Node(key,val));
        }else {
            parent.setTag(key)
            parent.setChildren(val);
        }
        return handleEndNode(str, index, key); //叶子节点 return
    } else {
        //遇到<a></a>要跑错
        if (str[index + 1] == '/') throw new Error('格式错误');
        let body;
        if (parent instanceof Array) {
            body=new Node();
            parent.getChildren().push(body);
        }else {
            parent.setTag(key);
            body=[];
            parent.setChildren(body);
            body=parent;
        }
        do {
            index = parse(str, body, index);
        } while (str[index] == '<' && str[index + 1] != '/');//处理所有的子节点

        return handleEndNode(str, index, key); //处理非叶子节点，但是自己包裹的那块完毕后return
    }
}
console.info(JSON.stringify(xml2json(xml)) );
console.log(JSON.stringify(xml2json(xml)) === JSON.stringify(json))
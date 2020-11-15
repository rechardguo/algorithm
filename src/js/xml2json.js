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

function xml2json (xml) {
    let result;



    return result
}


console.log(JSON.stringify(xml2json(xml)) === JSON.stringify(json))
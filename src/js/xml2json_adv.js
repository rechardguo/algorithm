// 原始 xml
const xml = `
<list>
  <item key="1">content1</item>
  <item key="2">content2</item>
  <item key="3">content3</item>
  <item key="4">
    <name id="hema-name">hema</name>
    <value id="hema-value">frontend</value>
  </item>
</list>
`

// 生成的 json
const json = {
    tag: 'list',
    children: [
        {
            tag: 'item',
            children: 'content1',
            props: {
                key: '1'
            }
        },
        {
            tag: 'item',
            children: 'content2',
            props: {
                key: '2'
            }
        },
        {
            tag: 'item',
            children: 'content3',
            props: {
                key: '3'
            }
        },
        {
            tag: 'item',
            children: [
                {
                    tag: 'name',
                    children: 'hema',
                    props: {
                        id: 'hema-name'
                    }
                },
                {
                    tag: 'value',
                    children: 'frontend',
                    props: {
                        id: 'hema-value'
                    }
                }
            ],
            props: {
                key: '4'
            }
        }
    ]
}

function xml2json (xml) {
    let result;



    return result
}


console.log(JSON.stringify(xml2json(xml)) === JSON.stringify(json))
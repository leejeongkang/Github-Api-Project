<template lang="html">
  <div class="table-box">
    <table class="table table--primary">
      <caption class="hidden">Table</caption>
      <thead>
      <tr>
        <th v-for="(item, index) in tableHead" :key="index">{{ item.title }}</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableLow" :key="index">
        <td>{{ item.content1 }}</td>
        <td>{{ item.content2 }}</td>
        <td>{{ item.content3 }}</td>
        <td>{{ item.content4 }}</td>
        <td>{{ item.content5 }}</td>
        <td>{{ item.content6 }}</td>
        <td>{{ item.content7 }}</td>
        <td>{{ item.content8 }}</td>
        <td>{{ item.content9 }}</td>
        <td>{{ item.content10 }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script type="text/javascript">

export default {
  name: "GroupFormBoxVertical",
  extends: {},
  props: {},
  components: {},
  data() {
    return {
      tableHead: [
        {title: '항목'},
        {title: '설명'},
        {title: '데이터타입'},
        {title: '데이터길이'},
        {title: '소수점'},
        {title: 'PK'},
        {title: 'PK POSITION'},
        {title: 'NULL 여부'},
        {title: '코드여부'},
        {title: 'DFAULT'}
      ],
      tableLow: [
        {
          content1: '교통정보코드',
          content2: '사업자구코드',
          content3: 'VARCHAR2',
          content4: '6',
          content5: '5',
          content6: 'Y',
          content7: '1',
          content8: 'Y',
          content9: 'Y',
          content10: 'SYSDATE'
        },
        {
          content1: '사업자구코드',
          content2: '사업자구코드',
          content3: 'VARCHAR2',
          content4: '6',
          content5: '5',
          content6: 'Y',
          content7: '1',
          content8: 'Y',
          content9: 'Y',
          content10: 'SYSDATE'
        },
        {
          content1: '자료형식',
          content2: '사업자구코드',
          content3: 'VARCHAR2',
          content4: '6',
          content5: '5',
          content6: 'Y',
          content7: '1',
          content8: 'Y',
          content9: 'Y',
          content10: 'SYSDATE'
        },
        {
          content1: '자료형식',
          content2: '사업자구코드',
          content3: 'VARCHAR2',
          content4: '6',
          content5: '5',
          content6: 'Y',
          content7: '1',
          content8: 'Y',
          content9: 'Y',
          content10: 'SYSDATE'
        },
        {
          content1: '자료형식',
          content2: '사업자구코드',
          content3: 'VARCHAR2',
          content4: '6',
          content5: '5',
          content6: 'Y',
          content7: '1',
          content8: 'Y',
          content9: 'Y',
          content10: 'SYSDATE'
        }
      ]
    }
  },
  watch: {},
  methods: {}
}
</script>

<style lang="scss" scoped>
@import "group-formbox-vertical";
</style>

<template lang="html">
  <!-- form--bg 클래스를 제거시, th에 background 스타일이 제거됩니다 -->
  <table class="table table--vertical">
    <caption class="hidden">상세내용</caption>
    <colgroup>
      <col style="width:150px" />
      <col style="width:auto" />
      <col style="width:150px" />
      <col style="width:auto" />
    </colgroup>
    <tbody>
    <tr v-for="(item, index) in tableLow" :key="index">
      <th scope="row">{{ item.title1 }}</th>
      <td>{{ item.content1 }}</td>
      <th scope="row">{{ item.title2 }}</th>
      <td>{{ item.content2 }}</td>
    </tr>
    </tbody>
  </table>
</template>
<script type="text/javascript">

export default {
  name: "GroupFormBox",
  extends: {},
  props: {},
  components: {},
  data() {
    return {
      tableLow: [
        {title1: '제공기관내의 해당부서의 해당과', content1: '농림축산검역본무', title2: '분류체계', content2: '축산'},
        {title1: '제공기관내의 해당부서의 해당과', content1: '농림축산검역본무', title2: '분류체계', content2: '축산'},
        {title1: '제공기관내의 해당부서의 해당과', content1: '농림축산검역본무', title2: '분류체계', content2: '축산'},
        {title1: '제공기관내의 해당부서의 해당과', content1: '농림축산검역본무', title2: '분류체계', content2: '축산'}
      ]
    }
  },
  watch: {},
  methods: {}
}
</script>

<style lang="scss" scoped>
@import "group-formbox";
</style>

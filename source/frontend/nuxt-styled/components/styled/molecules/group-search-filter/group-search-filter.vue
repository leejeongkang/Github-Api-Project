<template lang="html">
  <div class="search-filter">
    <div class="search-filter__head">
      <base-checkbox class="checkbox--lg" name="searchFilterAll" checkbox-id="searchFilterAll1">
        <template v-slot:label>
          전체선택
        </template>
      </base-checkbox>
    </div>
    <div class="search-filter__body">
      <ul class="search-filter__list">
        <li class="search-filter__item" v-for="(item, index) in searchFilterList" :key="index">
          <div class="search-filter__item-group">
          <base-checkbox name="searchFilter" :checkbox-id="item.checkboxId">
            <template v-slot:label>
<!--              <span class="search-filter__icon">-->
<!--                <svg-icon name="map" class="svg-icon" />-->
<!--              </span>-->
              {{ item.title }}
            </template>
          </base-checkbox>
<!--          <span class="search-filter__count">22</span>-->
          </div>
          <div class="search-filter__next">
            <ul class="search-filter__list">
              <li class="search-filter__item" v-for="(nextItem, index) in item.nextSearchFilterList" :key="index">
                <base-checkbox name="NextSearchFilter" :checkbox-id="nextItem.checkboxId">
                  <template v-slot:label>
                    {{ item.title }}
                  </template>
                </base-checkbox>
              </li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script type="text/javascript">
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox.vue";

export default {
  name: "GroupSearchFilter",
  props:{
  },
  components: {
    BaseCheckbox
  },
  data() {
    return {
      searchFilterList: [
        {
          checkboxId: '1',
          title: "필터 타이틀 1",
          nextSearchFilterList: [
            {
              checkboxId: '2depth-1',
              title: "2 Depth 필터 타이틀 1"
            },
            {
              checkboxId: '2depth-2',
              title: "2 Depth 필터 타이틀 1"
            },
            {
              checkboxId: '2depth-3',
              title: "2 Depth 필터 타이틀 1"
            }
          ]
        },
        {
          checkboxId: '2',
          title: "필터 타이틀 2 ",
          nextSearchFilterList: [
            {
              checkboxId: '2depth-1',
              title: "2 Depth 필터 타이틀 1"
            }
          ]
        },
        {
          checkboxId: '3',
          title: "필터 타이틀 3 "
        },
        {
          checkboxId: '4',
          title: "필터 타이틀 4 ",
          nextSearchFilterList: [
            {
              checkboxId: '2depth2-1',
              title: "2 Depth 필터 타이틀 1"
            },
            {
              checkboxId: '2depth2-1',
              title: "2 Depth 필터 타이틀 1"
            },
            {
              checkboxId: '2depth2-1',
              title: "2 Depth 필터 타이틀 1"
            }
          ]
        },
        {
          checkboxId: '5',
          title: "필터 타이틀 5 "
        },
        {
          checkboxId: '6',
          title: "필터 타이틀 6 "
        },
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
@import "./group-search-filter.scss";
</style>

import StoriesContainer from "@component/stories-container.vue";

import GroupCheckbox from "./group-checkbox.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 체크박스',
  components: GroupCheckbox,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 여러가지 체크박스 그룹 유형 </h2><story /></div>',
    }),
  ],
};

const Template = (args, { argTypes }) => {
  return {
    props: Object.keys(argTypes),
    components: { StoriesContainer, GroupCheckbox },
    template:
      "<StoriesContainer>" +
      `<h4 style="margin-bottom: 4px; margin-bottom: 12px; font-size: 16px; color: #666;">${args.title}</h4>` +
      `
        <GroupCheckbox checkbox-class="${args.checkboxClass}" checkboxesClass="${
        args.checkboxesClass
      }" name="${
        args.checkboxName
      }" checkbox-id1="checkbox-1" checkbox-id2="checkbox-2" v-bind="$props">
        <template v-if="${"label1" in args}" v-slot:label1>${
        args.label1
      }</template>
        <template v-if="${"label2" in args}" v-slot:label2>${
        args.label2
      }</template>
        </GroupCheckbox>
    ` +
      "</StoriesContainer>",
  };
};

export const Default = Template.bind({});
Default.args = {
  title: "기본 체크박스",
  checkboxName: "checkboxBasic",
  checkboxClass: "",
  checkboxesClass: "",
};

export const CheckboxRight = Template.bind({});
CheckboxRight.args = {
  title: "레이블이 우측인 체크박스",
  checkboxName: "checkboxBasic",
  checkboxClass: "checkbox--right",
  checkboxesClass: "",
};

export const CheckboxToggle = Template.bind({});
CheckboxToggle.args = {
  title: "토글 버튼 체크박스",
  checkboxName: "checkboxToggle",
  checkboxClass: "",
  checkboxesClass: "checkboxes--toggle",
};

export const CheckboxToggleIcon = Template.bind({});
CheckboxToggleIcon.args = {
  title: "토글 버튼 아이콘 체크박스",
  checkboxName: "checkboxToggleIcon",
  checkboxClass: "checkbox--icon",
  checkboxesClass: "checkboxes--toggle",
  label1: `<svg-icon name="app-switcher" class="svg-icon"/><span class="hidden">목록형</span>`,
  label2: `<svg-icon name="menu" class="svg-icon"/><span class="hidden">카드형</span>`,
};

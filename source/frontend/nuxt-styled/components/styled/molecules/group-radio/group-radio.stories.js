import StoriesContainer from "@component/stories-container.vue";

import GroupRadio from "./group-radio.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 라디오',
  components: GroupRadio,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 라디오 인풋 그룹 </h2><story /></div>',
    }),
  ],
};

const Template = (args, { argTypes }) => {
  return {
    props: Object.keys(argTypes),
    components: { StoriesContainer, GroupRadio },
    template:
      "<StoriesContainer>" +
      `<h4 style="margin-bottom: 4px; margin-bottom: 12px; font-size: 16px; color: #666;">${args.title}</h4>` +
      `
        <GroupRadio radio-class="${args.radioClass}" radiosClass="${
        args.radiosClass
      }" name="${
        args.radioName
      }" radio-id1="radio-1" radio-id2="radio-2" v-bind="$props">
        <template v-if="${"label1" in args}" v-slot:label1>${
        args.label1
      }</template>
        <template v-if="${"label2" in args}" v-slot:label2>${
        args.label2
      }</template>
        </GroupRadio>
    ` +
      "</StoriesContainer>",
  };
};

export const Default = Template.bind({});
Default.args = {
  title: "기본 라디오",
  radioName: "radioBasic",
  radioClass: "",
  radiosClass: "",
};

export const RadioRight = Template.bind({});
RadioRight.args = {
  title: "레이블이 우측인 라디오",
  radioName: "radioBasic",
  radioClass: "radio--right",
  radiosClass: "",
};

export const RadioToggle = Template.bind({});
RadioToggle.args = {
  title: "토글 버튼 라디오",
  radioName: "radioToggle",
  radioClass: "",
  radiosClass: "radios--toggle",
};

export const RadioToggleIcon = Template.bind({});
RadioToggleIcon.args = {
  title: "토글 버튼 아이콘 라디오",
  radioName: "radioToggleIcon",
  radioClass: "radio--icon",
  radiosClass: "radios--toggle",
  label1: `<svg-icon name="app-switcher" class="svg-icon"/><span class="hidden">목록형</span>`,
  label2: `<svg-icon name="menu" class="svg-icon"/><span class="hidden">카드형</span>`,
};

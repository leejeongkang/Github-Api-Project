import StoriesContainer from "@component/stories-container.vue";

import GroupInput from "./group-input.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 정렬',
  components: GroupInput,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 정렬 </h2><story /></div>',
    }),
  ],
};

const Template = (args, {argTypes}) => {
  return {
    props: Object.keys(argTypes),
    components: {StoriesContainer, GroupInput},
    template:
      "<StoriesContainer>" +
      `<h4 style="margin-bottom: 4px; margin-bottom: 12px; font-size: 16px; color: #666;">${args.title}</h4>` +
      `
        <GroupInput input-class="${args.inputClass}" inputesClass="${
        args.inputesClass
      }" name="${
        args.inputName
      }" v-bind="$props">
        </GroupInput>
    ` +
      "</StoriesContainer>",
  };
};

export const Default = Template.bind({});
Default.args = {
  title: "기본 정렬된 Input",
  inputName: "inputBasic",
  inputClass: "col-6",
  inputesClass: "",
};

export const InputSpacing = Template.bind({});
InputSpacing.args = {
  title: "간격이 추가된 정렬 Input",
  inputName: "inputBasic",
  inputClass: "col-6",
  inputesClass: "gap-20",
};


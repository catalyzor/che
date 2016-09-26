package process

import (
	"github.com/eclipse/che/exec-agent/rpc"
	"time"
)

const (
	StartedEventType = "process_started"
	DiedEventType    = "process_died"
	StdoutEventType  = "process_stdout"
	StderrEventType  = "process_stderr"
)

type ProcessStatusEventBody struct {
	rpc.Timed
	Pid         uint64 `json:"pid"`
	NativePid   int    `json:"nativePid"`
	Name        string `json:"name"`
	CommandLine string `json:"commandLine"`
}

type ProcessOutputEventBody struct {
	rpc.Timed
	Pid  uint64 `json:"pid"`
	Text string `json:"text"`
}

func newStderrEvent(pid uint64, text string, when time.Time) *rpc.Event {
	return rpc.NewEvent(StderrEventType, &ProcessOutputEventBody{
		Timed: rpc.Timed{Time: when},
		Pid:   pid,
		Text:  text,
	})
}

func newStdoutEvent(pid uint64, text string, when time.Time) *rpc.Event {
	return rpc.NewEvent(StdoutEventType, &ProcessOutputEventBody{
		Timed: rpc.Timed{Time: when},
		Pid:   pid,
		Text:  text,
	})
}

func newStatusEvent(mp MachineProcess, status string) *rpc.Event {
	return rpc.NewEvent(status, &ProcessStatusEventBody{
		Timed:       rpc.Timed{Time: time.Now()},
		Pid:         mp.Pid,
		NativePid:   mp.NativePid,
		Name:        mp.Name,
		CommandLine: mp.CommandLine,
	})
}

func newStartedEvent(mp MachineProcess) *rpc.Event {
	return newStatusEvent(mp, StartedEventType)
}

func newDiedEvent(mp MachineProcess) *rpc.Event {
	return newStatusEvent(mp, DiedEventType)
}
